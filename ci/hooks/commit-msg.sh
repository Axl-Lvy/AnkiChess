#!/usr/bin/env bash

# Check if we are on master branch
BRANCH=$(git rev-parse --abbrev-ref HEAD)
if [ "$BRANCH" != "master" ]; then
  # Not on master branch, exit successfully without checks
  exit 0
fi

# the commit message file is the only argument
msg_file="$1"

# join types with | to form regex ORs
types=("feat" "fix" "docs" "test" "ci" "refactor" "perf" "chore")
r_types="($(IFS='|'; echo "${types[*]}"))"
# optional (scope)
r_scope="(\([[:alnum:] \/-]+\))?"
# optional breaking change indicator and colon delimiter
r_delim='!?:'
# subject line, body, footer
r_subject=" [[:graph:]].+"
# the full regex pattern
pattern="^$r_types$r_scope$r_delim$r_subject$"

# Check if commit is conventional commit
if grep -Eq "$pattern" "$msg_file"; then
    exit 0
fi

if test -t 1 && test -n "$(tput colors)"; then
    RED='\033[0;31m'
    GREEN='\033[0;32m'
    BLUE='\033[0;34m'
    PURPLE='\033[0;35m'
    NC='\033[0m'
fi

echo -e "${RED}ERROR: Invalid commit message${NC}:
${PURPLE}$( cat "$msg_file" )${NC}
"
echo -e "
Your commit message does ${RED}not${NC} follow ${PURPLE}Conventional Commits${NC} formatting: ${BLUE}https://www.conventionalcommits.org/${NC}
Conventional Commits start with one of the following types:
    ${GREEN}$(IFS=' '; echo "${types[*]}")${NC}
followed by an ${PURPLE}optional scope within parentheses${NC},
followed by an ${RED}exclamation mark${NC} (${RED}!${NC}) in case of ${RED}breaking change${NC},
followed by a colon (:),
followed by the commit message.
Example commit message fixing a bug non-breaking backwards compatibility:
    ${GREEN}fix(module): fix bug #42${NC}
Example commit message adding a non-breaking feature:
    ${GREEN}feat(module): add new API${NC}
Example commit message with a breaking change:
    ${GREEN}refactor(module)!: remove infinite loop${NC}
"
exit 1