package proj.memorchess.axl.game

/** Retrieves a list of games defined by moves. */
fun getGames(): List<List<String>> {
  val games = mutableListOf<List<String>>()
  for (game in
    pgnString.split("\n\n").map { it.replace("\r", "").replace("\n", " ").replace(". ", ".") }) {
    games.add(getGame(game))
  }
  return games
}

/** Retrieves a list of moves for the Vienna game. */
fun getVienna(): List<String> {
  return getGame(pgnVienna)
}

/** Retrieves a list of moves for the London game. */
fun getLondon(): List<String> {
  return getGame(pgnLondon)
}

/** Retrieves a list of moves for the Scandinavian game. */
fun getScandinavian(): List<String> {
  return getGame(pgnScandinavian)
}

/** Parses a PGN string and returns a list of moves. */
private fun getGame(pgn: String): List<String> {
  val game = mutableListOf<String>()
  val moves = pgn.split(" ")
  for (move in
    moves.subList(0, moves.size - 1).map {
      val splited = it.split(".")
      if (splited.size == 2) {
        splited[1].trim()
      } else {
        splited[0].trim()
      }
    }) {
    game.add(move)
  }
  return game
}

private val pgnVienna =
  """
    1.e4 e5 2.Nc3 Nf6 3.f4 d5 4.fxe5 Nxe4 5.Qf3
  """
    .trimIndent()

private val pgnLondon =
  """
    1.d4 d5 2.Bf4 Nf6 3.e3 e6 4.Nf3 Bd6 5.Bg3 O-O
  """
    .trimIndent()

private val pgnScandinavian =
  """
    1.e4 d5 2.exd5 Qxd5 3.Nc3 Qa5 4.d4 c6
  """
    .trimIndent()

private val pgnString =
  """
  1.c4 e6 2.Nc3 d5 3.d4 c6 4.Nf3 Nf6 5.Bg5 dxc4 6.e4 b5 7.e5 h6
  8.Bxf6 gxf6 9.exf6 Bb4 10.Be2 Qxf6 11.O-O Bxc3 12.bxc3 Nd7
  13.a4 Bb7 14.Ne5 Nxe5 15.dxe5 Qxe5 16.Bf3 Rd8 17.Qc2 Rd3
  18.axb5 Rxf3 19.Rxa7 Qxb5 20.gxf3 Qg5+ 21.Kh1 Rg8 0-1

  1.e4 c6 2.d4 d5 3.exd5 cxd5 4.Bd3 Nf6 5.h3 h6 6.Bf4 e6 7.Nf3
  Bd6 8.Bxd6 Qxd6 9.c3 Nc6 10.O-O O-O 11.Qe2 Re8 12.Ne5 Qc7
  13.f4 Nxe5 14.fxe5 Nh7 15.Qh5 Re7 16.Na3 a6 17.Nc2 Qd7 18.Ne3
  Qe8 19.Rf6 Qf8 20.Rf4 Bd7 21.Ng4 Be8 22.Nf6+ Nxf6 23.exf6 Rc7
  24.fxg7 Kxg7 25.Qe5+ 1-0

  1.d4 d5 2.c4 c6 3.Nc3 Nf6 4.Nf3 g6 5.e3 Bg7 6.Bd3 O-O 7.O-O c5
  8.dxc5 dxc4 9.Bxc4 Qxd1 10.Rxd1 Nbd7 11.e4 Nxc5 12.e5 Nfd7
  13.Nd5 Nxe5 14.Nxe7+ Kh8 15.Nxe5 Bxe5 16.Rd5 Bf6 17.Rxc5 Bxe7
  18.Rc7 Bd6 19.Rxf7 Rxf7 20.Bxf7 Be5 21.Bh6 Bf5 22.Bd5 Bxb2
  23.Re1 Bd7 24.Bxb7 Re8 25.Rxe8+ Bxe8 26.Bd5 Bb5 27.g3 a6
  28.Kg2 Be2 29.Be6 Bd4 30.g4 Be5 31.f4 Bd4 32.Kg3 Be3 33.Kh4
  Bf2+ 34.Kg5 Bd4 35.Bf8 Bg7 36.Bxg7+ Kxg7 37.f5 h6 38.Kf4 Kf6
  39.h4 g5 40.hxg5+ hxg5 41.Kg3 Ke5 42.Bc8 Bc4 43.a3 a5 44.Kf3
  Bf7 45.Bb7 Bg8 46.Ke3 Bf7 47.Bf3 Bg8 48.Kd3 Ba2 49.Be2 Bd5
  50.Bd1 Bg8 51.Kc3 Bf7 52.Bb3 Be8 53.Bd1 Bf7 54.Bf3 Ba2 55.Bc6
  Bg8 56.Bb5 Bd5 57.Be2 Bf7 58.Bc4 Be8 59.Kb3 Bc6 60.Be2 a4
  61.Kb4 Kf6 62.Kc5 Be8 63.Bb5 1-0

  1.d4 Nf6 2.c4 c5 3.d5 e6 4.Nc3 exd5 5.cxd5 d6 6.Nf3 g6 7.Bg5
  Bg7 8.e3 O-O 9.Nd2 a6 10.a4 Qc7 11.Be2 Nbd7 12.O-O Rb8 13.Qc2
  Re8 14.e4 Nb6 15.Rae1 Bd7 16.Bf4 Nc8 17.h3 b5 18.axb5 axb5
  19.Bg3 b4 20.Nd1 b3 21.Qb1 Rb4 22.Nc3 Nb6 23.Bd1 Bc8 24.Be2 c4
  25.Qa1 Qc5 26.Bf4 Nfd7 27.Be3 Qc7 28.Qa5 Bxc3 29.bxc3 Ra4
  30.Qb5 Re7 31.Ra1 Ba6 32.Qc6 Qxc6 33.dxc6 Nc5 34.Rxa4 Nbxa4
  35.Bxc4 Bxc4 36.Nxc4 Nxc3 37.Ra1 N5a4 38.Bd4 Ne2+ 39.Kf1 Nxd4
  40.Rxa4 Nxc6 41.Ra6 Rc7 42.Nxd6 b2 43.Rb6 Nb4 44.Rxb4 Rc1+
  45.Ke2 b1=Q 46.Rxb1 Rxb1 47.Nc4 1/2-1/2

  1.d4 Nf6 2.c4 g6 3.Nc3 Bg7 4.e4 d6 5.f3 O-O 6.Be3 e5 7.d5 Ne8
  8.Qd2 f5 9.O-O-O f4 10.Bf2 Nd7 11.Nge2 Nb6 12.Qd3 g5 13.Kb1
  Bd7 14.Nc1 c5 15.dxc6 bxc6 16.c5 Nc8 17.cxd6 Nexd6 18.Bc5 Rf6
  19.Be2 Qc7 20.Nb3 Be8 21.Nd5 cxd5 22.Qxd5+ Nf7 23.Qxa8 Bc6
  24.Bb6 axb6 25.Rc1 Bxa8 26.Rxc7 Rc6 27.Rc1 Rxc7 28.Rxc7 Ncd6
  29.Nd2 Bf8 30.Bc4 b5 31.Be6 Kg7 32.a4 Kf6 33.Bxf7 Nxf7 34.axb5
  Bb4 35.Nc4 g4 36.Ra7 gxf3 37.gxf3 Bxe4+ 38.fxe4 Ng5 39.b6 Bc5
  40.Ra6 Ne6 41.b7 1-0

  1.Nf3 Nf6 2.d4 g6 3.c4 Bg7 4.g3 O-O 5.Bg2 d6 6.O-O c5 7.Nc3
  Nc6 8.h3 cxd4 9.Nxd4 Nxd4 10.Qxd4 Be6 11.Qh4 Qc8 12.b3 Ng4
  13.hxg4 Bxc3 14.Rb1 Bxg4 15.Qxe7 Qf5 16.Qe3 Bg7 17.Be4 Qh5
  18.Bf3 Rfe8 19.Bxg4 Qxg4 20.Qf3 Qxf3 21.exf3 Re2 22.Rd1 Rxa2
  23.Rxd6 Bf8 24.Rd5 a5 25.Be3 Rc8 26.Rbd1 Rb2 27.Rd8 Rxd8
  28.Rxd8 Rb1+ 29.Kg2 Kg7 30.Bd4+ f6 31.Rd7+ Kg8 32.Rxb7 a4
  33.c5 Rxb3 34.c6 Rxb7 35.cxb7 Bd6 36.Bxf6 Kf7 37.Bb2 g5 38.f4
  gxf4 39.Bc1 fxg3 40.fxg3 Bb8 41.Bf4 Ba7 42.Be3 Bb8 43.Bf4 Ba7
  44.Bc1 Ke6 45.Kf3 Kd7 46.Bf4 a3 47.b8=Q Bxb8 48.Bxb8 Ke6
  49.Kf4 Kf6 50.Be5+ Kg6 51.Ba1 a2 52.Bb2 h5 53.Ba1 Kh6 1/2-1/2

  1.e4 c5 2.Nf3 Nc6 3.c3 d5 4.exd5 Qxd5 5.d4 Bg4 6.Be2 e6 7.O-O
  Nf6 8.h3 Bh5 9.Be3 cxd4 10.Nxd4 Bxe2 11.Qxe2 Nxd4 12.Bxd4 Be7
  13.Nd2 O-O 14.Rfd1 Qf5 15.Bxf6 Bxf6 16.Ne4 Rab8 17.Rd7 a5
  18.a4 Qe5 19.Nxf6+ gxf6 20.Qxe5 fxe5 21.Re1 f6 22.c4 Rf7
  23.Red1 Rc8 24.b3 Rc7 25.Rxc7 Rxc7 26.Rd6 Kf7 27.Kf1 f5 28.g3
  Kf6 29.Rb6 f4 30.gxf4 exf4 31.Ke2 Kf5 32.f3 Ke5 33.Kd3 Rd7+
  34.Kc3 Kf5 35.Rb5+ e5 36.Rxa5 Rd1 37.Rd5 Rh1 38.a5 Rxh3 39.Rd3
  Rg3 40.Kd2 Rg2+ 41.Ke1 Rb2 42.c5 h5 43.Kf1 h4 44.Rc3 h3 45.Kg1
  e4 46.a6 e3 47.axb7 Rb1+ 48.Kh2 e2 49.Re3 fxe3 50.b8=Q Rh1+
  51.Kxh1 e1=Q+ 52.Kh2 Qf2+ 53.Kxh3 Qxf3+ 54.Kh2 e2 55.Qf8+ Ke4
  56.Qe8+ Kd3 57.Qb5+ Kc3 0-1

  1.d4 Nf6 2.c4 g6 3.Nc3 Bg7 4.e4 O-O 5.Be3 d6 6.f3 e5 7.Nge2 c6
  8.Qb3 Nbd7 9.O-O-O Qe7 10.Kb1 Re8 11.g4 a6 12.Ng3 Nf8 13.d5
  N6d7 14.h4 c5 15.Be2 Rb8 16.Rdg1 b5 17.h5 b4 18.Na4 Nb6
  19.Nxb6 Rxb6 20.Qd3 Rb7 21.Qd2 f6 22.hxg6 Nxg6 23.Nf5 Bxf5
  24.gxf5 Nf4 25.Bd1 Kh8 26.Qh2 h6 27.Bxf4 exf4 28.Rg6 Qf8
  29.Qxf4 Kh7 30.Ba4 Rd8 31.Rhg1 Ra7 32.Qh4 Rc7 33.Bd1 Re8
  34.Be2 a5 35.Bf1 a4 36.Bh3 a3 37.b3 Rf7 38.Bg4 Ra7 39.Bh5 Rd8
  40.Rxg7+ Rxg7 41.Bg6+ Kg8 42.Qxh6 Qe7 43.Bh7+ Kh8 44.Bg6+ Kg8
  45.Kc1 Rd7 46.Rh1 Kf8 47.f4 Rc7 48.Kd2 Rd7 49.Kd3 Rc7 50.Re1
  Kg8 51.e5 dxe5 52.fxe5 fxe5 53.Rh1 1-0

  1.e4 e6 2.d4 d5 3.Nd2 c5 4.exd5 Qxd5 5.Ngf3 Nc6 6.Bc4 Qh5
  7.dxc5 Bxc5 8.Ne4 Nge7 9.Bg5 Qg4 10.Qd3 b6 11.O-O-O O-O 12.Bf6
  Qf4+ 13.Kb1 gxf6 14.g3 Qh6 15.g4 Qf4 16.g5 fxg5 17.Nfxg5 Ng6
  18.h4 Nb4 19.Qh3 e5 20.Qg2 Bf5 21.h5 Kg7 22.hxg6 h6 23.Bxf7
  Rxf7 24.gxf7 hxg5 25.Nxg5 Qxf2 26.Ne6+ Kxf7 27.Qg7+ Kxe6
  28.Rh6+ Bg6 29.Qxg6+ Ke7 30.Rh7+ Kf8 31.Qg7+ Ke8 32.Qd7+ Kf8
  33.Rh8# 1-0

  1.d4 f5 2.e4 fxe4 3.Nc3 Nf6 4.f3 d5 5.fxe4 dxe4 6.Bc4 Bf5
  7.Nge2 Nc6 8.O-O e6 9.Bb5 a6 10.Ba4 Qd7 11.Bg5 O-O-O 12.Kh1
  Be7 13.Bxf6 Bxf6 14.d5 exd5 15.Bxc6 bxc6 16.Nd4 Bg4 17.Qd2 Qd6
  18.Nb3 c5 19.h3 h5 20.Na5 e3 21.Qxe3 d4 22.Qe4 dxc3 23.Qb7+
  Kd7 24.Nc4 Qd4 25.Nb6+ Ke8 26.bxc3 Qd6 27.Nc4 Qg3 28.Rae1+ Kf8
  29.Re3 Qh4 30.Qxc7 Kg8 31.Kg1 Bc8 32.Rf4 Qg5 33.Ref3 Kh7 34.h4
  Rd1+ 35.Kh2 Qd5 36.Rg3 Bg4 37.Rxf6 Qxc4 38.Rf5 Kh6 39.Rxh5+
  Kxh5 40.Qxg7 Qf4 41.Qxh8+ Kg6 42.Qg8+ Kf5 43.Qc8+ Ke5 44.Qxg4
  Qxg4 45.Rxg4 Rd2 46.Rg5+ Kf4 47.Rxc5 Rxc2 48.Rc6 Kg4 49.Rc4+
  Kh5 50.a4 Rd2 51.Kh3 Rd3+ 52.g3 Rd6 53.a5 Rd5 54.g4 Kg6
  55.Rc6+ Kf7 56.Rxa6 Rd3+ 57.Kg2 Rxc3 58.h5 Kg7 59.Rb6 Ra3
  60.a6 Kf7 61.Kh2 Kg7 62.g5 Ra5 63.Rb7+ Kg8 64.a7 1-0

  1.e4 c5 2.Nf3 d6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 a6 6.f4 e5 7.Nf3
  Nbd7 8.Bd3 Be7 9.O-O O-O 10.Kh1 b5 11.a3 Qc7 12.fxe5 dxe5
  13.Nh4 Nc5 14.Bg5 Qd8 15.Nf5 Bxf5 16.Rxf5 Nfd7 17.Bxe7 Qxe7
  18.Nd5 Qd6 19.Qg4 g6 20.Raf1 f6 21.h4 Kh8 22.R5f3 f5 23.exf5
  Qxd5 24.fxg6 Rxf3 25.g7 Kg8 26.Bxh7+ Kxh7 27.Rxf3 Ne4 28.h5
  Ndf6 29.Qg6+ Kg8 30.h6 Ra7 31.Kh2 Re7 32.Rh3 Nh7 33.Rd3 Qa8
  34.Qxe4 Qxe4 35.Rd8+ Kf7 36.g8=Q+ Kf6 37.Rd6+ Kf5 38.Qg6+ Kf4
  39.g3+ Ke3 40.Rd3+ Qxd3 1-0

  1.d4 Nf6 2.c4 c5 3.d5 e6 4.Nc3 exd5 5.cxd5 d6 6.e4 g6 7.Nf3
  Bg7 8.Bd3 O-O 9.O-O Na6 10.Nd2 Nb4 11.Be2 Re8 12.a3 Na6 13.Re1
  Nc7 14.Qc2 Rb8 15.a4 b6 16.Nb5 a6 17.Nxc7 Qxc7 18.Ra2 Qe7
  19.f3 Nh5 20.Nf1 f5 21.Bd3 f4 22.g4 Bd4+ 23.Kh1 Qh4 24.Re2 Qh3
  25.Rg2 Qxf3 26.Nd2 Qe3 27.Nf1 Qf3 28.Nd2 Bxg4 29.Nxf3 Bxf3
  30.h4 Rf8 31.Be2 Ng3+ 32.Kh2 Bxg2 33.Kxg2 Nxe2 34.Qxe2 f3
  35.Qxf3 Rxf3 36.Kxf3 Rf8+ 37.Kg3 Be5+ 38.Kg2 Bf4 0-1

  1.e4 e5 2.Nf3 Nc6 3.Bb5 a6 4.Ba4 Nf6 5.O-O Be7 6.d4 exd4 7.e5
  Nd5 8.Nxd4 Nxd4 9.Qxd4 Nb6 10.Qg4 Nxa4 11.Qxg7 Rf8 12.Bh6 d5
  13.Qxh7 Bd7 14.Nd2 Bb5 15.c4 dxc4 16.Ne4 Nxb2 17.Bxf8 Bxf8
  18.Nf6+ Ke7 19.Rfe1 Qd4 20.Re4 Qc5 21.e6 Kd6 22.e7+ Kc6
  23.Qxf7 Bxe7 24.Rxe7 Kb6 25.Rxc7 Qd4 26.Rxb7+ Ka5 27.Qd5 Rd8
  28.Qxd4 Rxd4 29.h3 c3 30.Rc1 Kb4 31.Re7 Bc4 32.Ne4 Rd1+
  33.Rxd1 Nxd1 34.Nxc3 Nxc3 35.h4 Bxa2 36.h5 a5 37.h6 Bb1 38.h7
  Bxh7 39.Rxh7 a4 40.g4 a3 41.Ra7 Na4 42.Rb7+ Kc3 43.Rb1 Kc2
  44.Re1 Nc3 45.g5 a2 46.g6 Nb1 47.g7 a1=Q 48.g8=Q Kd2 49.Qe6
  Qg7+ 50.Kf1 Nc3 51.Qe3+ Kc2 52.Rc1+ Kb3 53.Qxc3+ Qxc3 54.Rxc3+
  Kxc3 55.Ke2 Kd4 56.Kf3 Ke5 57.Kg4 Kf6 58.Kf4 1-0

  1.d4 Nf6 2.c4 c5 3.Nf3 e6 4.g3 cxd4 5.Nxd4 d5 6.Bg2 e5 7.Nf3
  d4 8.O-O Nc6 9.e3 Be7 10.exd4 exd4 11.Nbd2 Be6 12.Re1 O-O
  13.b3 Qd7 14.Bb2 Rad8 15.a3 a5 16.Ne5 Nxe5 17.Rxe5 b6 18.Nf3
  Bc5 19.Qd2 Ng4 20.Ree1 d3 21.Rf1 Qd6 22.Qc3 f6 23.Rad1 Rfe8
  24.Rd2 Bf5 25.Ng5 Ne3 26.fxe3 Bxe3+ 27.Kh1 Bxd2 28.Qxd2 Re2
  29.Qc3 Rxg2 0-1

  1.e4 e5 2.Nf3 Nc6 3.Nc3 Nf6 4.d4 exd4 5.Nd5 Nb4 6.Nxd4 Nxe4
  7.Nf5 c6 8.Nxb4 Bxb4+ 9.c3 Qf6 10.Qf3 Nxc3 11.a3 Ba5 12.Bd2 d5
  13.Ng3 Qe6+ 14.Qe3 d4 15.Qxe6+ Bxe6 16.f3 O-O-O 17.Kf2 Bb6
  18.bxc3 dxc3 19.Be3 Bxe3+ 20.Kxe3 Rhe8 21.Ne4 Bd5 22.g4 Bxe4
  23.fxe4 Rd5 24.Rc1 g6 25.Bg2 f5 26.gxf5 gxf5 27.Rhf1 fxe4
  28.Rxc3 Rh5 29.Rh1 Rh4 30.Rc4 Kc7 31.Rxe4 Rexe4+ 32.Bxe4 Rh3+
  33.Bf3 c5 34.Rg1 b5 35.Rg7+ Kb6 36.Rb7+ Ka6 37.Rb8 Rxh2 38.Be2
  Rh3+ 39.Ke4 c4 40.a4 Rh4+ 1-0

  1.e4 c6 2.d4 d6 3.Nc3 Nf6 4.f4 Qb6 5.Nf3 Bg4 6.Be2 Nbd7 7.e5
  Nd5 8.O-O Nxc3 9.bxc3 e6 10.Ng5 Bxe2 11.Qxe2 h6 12.Nxf7 Kxf7
  13.f5 dxe5 14.fxe6+ Kxe6 15.Rb1 Qxb1 16.Qc4+ Kd6 17.Ba3+ Kc7
  18.Rxb1 Bxa3 19.Qb3 Be7 20.Qxb7+ Kd6 21.dxe5+ Nxe5 22.Rd1+ Ke6
  23.Qb3+ Kf5 24.Rf1+ Ke4 25.Re1+ Kf5 26.g4+ Kf6 27.Rf1+ Kg6
  28.Qe6+ Kh7 29.Qxe5 Rhe8 30.Rf7 Bf8 31.Qf5+ Kg8 32.Kf2 Bc5+
  33.Kg3 Re3+ 34.Kh4 Rae8 35.Rxg7+ Kxg7 36.Qxc5 R8e6 37.Qxa7+
  Kg6 38.Qa8 Kf6 39.a4 Ke5 40.a5 Kd5 41.Qd8+ Ke4 42.a6 Kf3 43.a7
  Re2 44.Qd3+ R6e3 45.Qxe3+ 1-0

  1.e4 c5 2.Nf3 d6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 a6 6.Bg5 e6 7.f4
  Qb6 8.Qd2 Qxb2 9.Rb1 Qa3 10.e5 dxe5 11.fxe5 Nfd7 12.Ne4 Qxa2
  13.Rb3 Qa1+ 14.Kf2 Qa4 15.Bb5 axb5 16.Nxb5 f6 17.exf6 gxf6
  18.Re1 Ra6 19.Bxf6 Nxf6 20.Nxf6+ Kf7 21.Rf3 Qh4+ 22.Kf1 e5
  23.Qd5+ Be6 24.Nd7 Kg6 25.Nxe5+ Kg7 26.Rg3+ Qxg3 27.Qxb7+ Nd7
  28.hxg3 Rb6 29.Qc7 Bc5 30.Nxd7 Bc4+ 31.Re2 1-0

  1.e4 e5 2.Nf3 Nc6 3.Bb5 a6 4.Ba4 Nf6 5.O-O Be7 6.Re1 b5 7.Bb3
  d6 8.c3 O-O 9.h3 Nd7 10.d4 Nb6 11.Be3 exd4 12.cxd4 d5 13.Nc3
  dxe4 14.Nxe4 Bf5 15.d5 Na5 16.d6 cxd6 17.Bxb6 Qxb6 18.Ng3 Be6
  19.Bxe6 fxe6 20.Rxe6 Bf6 21.Rxd6 Qb8 22.Nh5 Bxb2 23.Rb1 Nc4
  24.Rd7 Ra7 25.Rxb2 Nxb2 26.Qd5+ Kh8 27.Qd4 Rxd7 28.Qxd7 Rg8
  29.Ng5 h6 30.Nf7+ Kh7 31.h4 Qc8 32.Nf6+ Kg6 33.Nxg8 Qxd7
  34.Ne5+ Kh7 35.Nxd7 Kxg8 36.Nc5 a5 37.Kf1 Nd1 38.Ne4 b4 39.Ke2
  Nb2 40.Kd2 a4 1/2-1/2

  1.d4 d5 2.c4 e6 3.Nc3 c5 4.e3 Nf6 5.Nf3 Nc6 6.a3 Bd6 7.dxc5
  Bxc5 8.b4 Bd6 9.Bb2 O-O 10.Qc2 Ne5 11.O-O-O Qe7 12.Nb5 Ned7
  13.Nxd6 Qxd6 14.Qc3 Re8 15.g4 Qf8 16.Bd3 Nb6 17.g5 Na4 18.Qc2
  Nxb2 19.Kxb2 dxc4 20.gxf6 cxd3 21.Qxd3 e5 22.Ng5 g6 23.h4 Bf5
  24.e4 Bg4 25.h5 Rad8 26.hxg6 Rxd3 27.Rxd3 hxg6 28.Rh7 Rc8
  29.f3 Rc6 30.Rxf7 Qxf7 31.Nxf7 Kxf7 32.fxg4 Kxf6 33.Rd7 Rb6
  34.Kc3 Kg5 35.a4 a6 36.Kc4 Kxg4 1/2-1/2

  1.c4 Nf6 2.Nc3 g6 3.e4 d6 4.d4 Bg7 5.f3 e5 6.Nge2 Nbd7 7.Bg5
  c6 8.Qd2 O-O 9.d5 c5 10.g4 a6 11.Ng3 Re8 12.h4 Qa5 13.Bh6 Nf8
  14.h5 Qc7 15.Bd3 b5 16.O-O-O bxc4 17.Bb1 Bh8 18.Rdg1 Rb8
  19.Nf5 N6d7 20.Bg5 Bg7 21.Nxg7 Kxg7 22.Bh6+ Kg8 23.f4 exf4
  24.Qxf4 Qd8 25.hxg6 Nxg6 26.Qh2 Nde5 27.Bf4 Nf8 28.Qh6 Neg6
  29.Bg5 f6 30.e5 Rxe5 31.Bxg6 Rb7 32.Ne4 fxg5 33.Rf1 Rxe4
  34.Bxe4 Rg7 35.Rf6 Bxg4 36.Rhf1 Nd7 37.Rxd6 Qe7 38.Rxa6 Kh8
  39.Bxh7 Nb8 40.Bf5 Kg8 41.Be6+ Bxe6 42.Rxe6 1-0

  1.e4 c5 2.Nf3 Nc6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 d6 6.Bc4 e6 7.O-O
  a6 8.Be3 Qc7 9.Bb3 Be7 10.f4 b5 11.f5 Nxd4 12.Qxd4 O-O 13.fxe6
  Bxe6 14.Rad1 Rac8 15.Kh1 Rfd8 16.Nd5 Bxd5 17.exd5 Nd7 18.Qf4
  Bf6 19.Bd4 Re8 20.c3 Re7 21.Bc2 Bxd4 22.Qh4 Nf8 23.Rxd4 Re2
  24.Bf5 Rce8 25.Rb4 Rd2 26.Be4 Qe7 27.Qe1 Rxd5 28.Qf2 Re5
  29.Bd3 Nd7 30.Rf4 Nc5 31.Rxf7 Nxd3 32.Qf3 Re1 33.Qd5 Qxf7
  34.Qxf7+ Kh8 35.Kg1 Rxf1+ 36.Qxf1 Re1 0-1

  1.e4 e5 2.Nf3 Nc6 3.Bb5 a6 4.Ba4 Nf6 5.O-O Be7 6.Re1 b5 7.Bb3
  O-O 8.c3 d6 9.h3 Na5 10.Bc2 c5 11.d4 Qc7 12.Nbd2 Bd7 13.Nf1
  Rfe8 14.Ne3 g6 15.b4 cxb4 16.cxb4 Nc4 17.Nxc4 bxc4 18.Re3 Bf8
  19.Bb2 Bh6 20.Ra3 Qb7 21.dxe5 Qxb4 22.Qd4 Nh5 23.exd6 Bg7
  24.e5 Bc6 25.Re3 Bxf3 26.Bc3 Qb5 27.gxf3 Rad8 28.f4 Re6 29.Rb1
  Qc6 30.Rb6 Qc8 31.Bd1 Bh6 32.Bxh5 gxh5 33.f5 1-0

  1.d4 e6 2.c4 f5 3.Nf3 Nf6 4.g3 Be7 5.Bg2 O-O 6.O-O d6 7.Nc3
  Qe8 8.Re1 Qg6 9.e4 fxe4 10.Nxe4 Nxe4 11.Rxe4 Nc6 12.Re3 Bf6
  13.d5 exd5 14.cxd5 Ne5 15.Nxe5 Bxe5 16.Rb3 Bf5 17.Rxb7 Bc2
  18.Qd2 Rae8 19.Rxc7 Bd3 20.Qb4 a5 21.Qa4 Bxg3 22.hxg3 Re1+
  23.Kh2 Be4 24.Be3 Qh5+ 25.Bh3 Rxe3 26.Rxg7+ Kxg7 27.Qd4+ Kg8
  28.Qxe3 Bf5 29.g4 Bxg4 30.Rg1 Rxf2+ 31.Kh1 Qxd5+ 32.Bg2 Qh5+
  33.Bh3 Qd5+ 34.Bg2 Qd2 35.Qxd2 Rxd2 36.Bf3 h5 37.Bxg4 hxg4
  38.Rxg4+ Kf7 39.Ra4 1/2-1/2

  1.d4 e6 2.c4 f5 3.Nf3 Nf6 4.Nc3 Be7 5.g3 O-O 6.Bg2 d6 7.O-O
  Qe8 8.Re1 Qg6 9.e4 fxe4 10.Nxe4 Nxe4 11.Rxe4 Nc6 12.Qe2 Bf6
  13.Bd2 e5 14.dxe5 dxe5 15.Bc3 Bf5 16.Nh4 Bxh4 17.Rxh4 Rae8
  18.Qe3 h6 19.b4 Qf6 20.b5 Nd8 21.Bd5+ Kh8 22.f4 exf4 23.Qd2
  Qb6+ 24.Bd4 Qg6 25.Qxf4 Kh7 26.Qxc7 Bb1 27.Be5 Ne6 28.Qd6 Qf5
  29.Bf4 Ng5 30.Qb4 Be4 31.Bxe4 Rxe4 32.Rf1 Re2 33.Qd6 Rxa2
  34.Qd5 Qc2 35.c5 Rd8 36.Bd6 Re8 0-1

  1.e4 c5 2.Nf3 Nc6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 d6 6.Bg5 Bd7
  7.Qd2 Nxd4 8.Qxd4 Qa5 9.Bxf6 gxf6 10.O-O-O Rc8 11.f4 Rg8 12.g3
  e6 13.Bh3 Qc5 14.Qd2 b5 15.Rhe1 b4 16.Ne2 Qc4 17.Kb1 Qxe4
  18.Nd4 Qb7 19.Qd3 Be7 20.Qxh7 Rf8 21.Bg4 Qc7 22.Ka1 f5 23.Bxf5
  exf5 24.Rxe7+ Kxe7 25.Re1+ Kd8 26.Qh4+ f6 27.Qh6 Qa5 28.Nb3
  Qd5 29.Qxf8+ Kc7 30.Qxf6
  Re8 31.Rc1 Ba4 32.Qd4 Qb7 33.Rd1 Re6 34.Qc4+ 1-0

  1.d4 Nf6 2.c4 e6 3.Nf3 c5 4.e3 d5 5.a3 cxd4 6.exd4 Be7 7.Nc3
  O-O 8.Bf4 Nc6 9.Rc1 Ne4 10.Bd3 Nxc3 11.Rxc3 dxc4 12.Rxc4 Qa5+
  13.Bd2 Qd5 14.Qc2 f5 15.O-O Bd7 16.Rd1 Rac8 17.Be3 Na5 18.Rxc8
  Rxc8 19.Qe2 Bd6 20.Ne5 Ba4 21.Re1 Bxe5 22.dxe5 Rd8 23.b4 Bc6
  24.f3 Qxd3 25.Qxd3 Rxd3 26.bxa5 Rxa3 27.Bxa7 Rxa5 28.Bd4 Ra2
  29.Rb1 Rd2 30.Bc3 Rc2 31.Bd4 Kf7 32.h4 Kg6 33.Rb4 h6 34.Rb2
  Rxb2 35.Bxb2 Kh5 36.Ba3 Kxh4 37.Bf8 Kg3 38.Bxg7 h5 39.Bh6 Bxf3
  40.gxf3 Kxf3 41.Kf1 b5 42.Bd2 h4 43.Bb4 h3 44.Kg1 Ke2 0-1

  1.e4 c5 2.Nf3 d6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 a6 6.Bg5 Nbd7
  7.Bc4 Qa5 8.Qd2 e6 9.O-O-O b5 10.Bxe6 fxe6 11.Nxe6 Kf7 12.Nxf8
  Rxf8 13.Qxd6 b4 14.Nd5 Qxa2 15.Rhe1 Kg8 16.Bxf6 gxf6 17.Rd3
  Qa1+ 18.Kd2 Qxb2 19.f4 b3 20.Ne7+ Kh8 21.Rxb3 Qa2 22.Qd5 Ra7
  23.Ng6+ Kg7 24.Nxf8 Kxf8 25.e5 Nxe5 26.Qc5+ Kg8 27.Qxc8+ Kf7
  28.fxe5 Qa5+ 29.Qc3 Rd7+ 30.Kc1 1-0

  1.d4 Nf6 2.Nf3 g6 3.c4 Bg7 4.Nc3 O-O 5.e4 d6 6.h3 e5 7.dxe5
  dxe5 8.Be3 Qe7 9.Qb3 Nc6 10.Nd5 Qd8 11.Bd3 Nd4 12.Bxd4 exd4
  13.O-O Nh5 14.g4 c6 15.gxh5 cxd5 16.cxd5 Qf6 17.Bc4 b5 18.Be2
  Re8 19.Qd3 Qf4 20.Rfe1 Rxe4 21.Qd2 Bb7 22.Qxf4 Rxf4 23.hxg6
  hxg6 24.Nd2 d3 25.Bxd3 Rd4 26.Nb3 Rxd3 27.Nc5 Rxd5 28.Nxb7 Rb8
  29.Na5 Bxb2 30.Nc6 Rg5+ 31.Kf1 Bxa1 32.Nxb8 Bd4 33.Nc6 Bb6
  34.Re4 Rc5 35.Nb4 a5 36.Nd3 Rc3 37.Nf4 Rf3 38.Nd5 Rxf2+ 39.Ke1
  Bc5 40.Nc7 Rxa2 41.Nxb5 Rh2 0-1

  1.d4 Nf6 2.c4 e6 3.Nc3 Bb4 4.e3 c5 5.Nf3 d5 6.Bd3 O-O 7.O-O
  Nbd7 8.a3 cxd4 9.Nxd5 exd5 10.axb4 dxc4 11.Bxc4 Nb6 12.Bb3
  dxe3 13.Bxe3 Nbd5 14.Bc5 Re8 15.Re1 Rxe1+ 16.Qxe1 b6 17.Bd4
  Bb7 18.Rd1 Qe8 19.Be5 Qb5 20.Bxf6 gxf6 21.Qe4 Qxb4 22.Nd4 f5
  23.Qe5 Ne7 24.Qf6 Bd5 25.Nc6 Qxb3 26.Nxe7+ Kf8 27.Re1 Be6
  28.Nxf5 1-0

  1.d4 Nf6 2.c4 e6 3.Nc3 c5 4.d5 exd5 5.cxd5 d6 6.e4 g6 7.Be2
  Bg7 8.Nf3 O-O 9.O-O Re8 10.Qc2 Na6 11.Bf4 Nb4 12.Qb1 Nxe4
  13.Nxe4 Bf5 14.Nfd2 Nxd5 15.Bxd6 Nf6 16.Bf3 Nxe4 17.Nxe4 Bxe4
  18.Bxe4 Qxd6 19.Qc2 Re7 20.Bf3 Rae8 21.Rad1 Bd4 22.a4 b6 23.b3
  Re5 24.Rd2 h5 25.Re2 Rxe2 26.Bxe2 h4 27.Kh1 Qf4 28.g3 Qf6
  29.Qd1 Rd8 30.Bg4 Bxf2 31.Qe2 Rd2 32.Qe8+ Kg7 33.gxh4 Qd4
  34.Bh3 Qd3 35.Bg2 Rd1 0-1

  1.e4 e5 2.Nf3 Nc6 3.Bb5 a6 4.Ba4 Nf6 5.O-O Be7 6.Re1 b5 7.Bb3
  O-O 8.c3 d6 9.h3 Na5 10.Bc2 c5 11.d4 Bb7 12.b4 cxb4 13.cxb4
  Nc4 14.Nbd2 d5 15.exd5 exd4 16.Nxc4 bxc4 17.Qxd4 Bxb4 18.Rb1
  Bxe1 19.Rxb7 Re8 20.d6 Qc8 21.Bg5 Re2 22.Rc7 Qe6 23.Nxe1 Rxe1+
  24.Kh2 Rd8 25.Bxf6 gxf6 26.Re7 Qxd6+ 27.Qxd6 Rxd6 28.Rxe1 Rd2
  29.Rc1 Rxf2 30.Be4 Rxa2 31.Rxc4 a5 32.Rc8+ Kg7 33.Rc7 1-0

  1. d4 Nf6 2. c4 e6 3. Nc3 Bb4 4. a3 Bxc3+ 5. bxc3 c5 6. e3 Nc6
  7. Bd3 e5 8. Ne2 e4 9. Bb1 b6 10. Ng3 Ba6 11. f3 Bxc4 12. Nf5
  O-O 13. Nd6 Bd3 14. Bxd3 exd3 15. Qxd3 cxd4 16. cxd4 Ne8
  17. Nf5 d5 18. a4 Nd6 19. Nxd6 Qxd6 20. Ba3 Nb4 21. Qb3 a5
  22. O-O Rfc8 23. Rac1 Qe6 24. Bxb4 axb4 25. Kf2 Qd6 26. h3 Kf8
  27. Rc2 Rxc2+ 28. Qxc2 g6 29. Rc1 Qd7 30. Qc6 Qxc6 31. Rxc6
  Ra6 32. a5 b3 33. axb6 b2 34. b7 b1=Q 35. Rc8+ Kg7 36. b8=Q
  Ra2+ 37. Kg3 Qe1+ 38. Kh2 Qxe3 39. Rg8+ Kf6 40. Qd6+ Qe6
  41. Qf4+ Qf5 42. Qd6+ Qe6 43. Qg3 Qe3 44. h4 Re2 45. Qd6+ Qe6
  46. Qf4+ Qf5 47. Qh6 Ke7 48. Qf8+ Kf6 49. Qg7+ Ke7 50. Ra8 Qd7
  51. Qf8+ Kf6 52. Ra6+ Re6 53. Qh8+ Ke7 54. Ra8 Re1 55. Kg3 h5
  56. Kf2 Re6 57. Rc8 Rd6 58. Qf8+ Kf6 59. Re8 Re6 60. Qh8+ Kf5
  61. Qh6 Kf6 62. Qh8+ Kf5 63. Rd8 Qc6 64. Rc8 Qa6 65. Kg3 Qd6+
  66. Kh3 Re1 67. g3 Rg1 68. f4 Re1 69. Rc2 Qe6 70. Rf2 Rh1+
  71. Kg2 Qe4+ 72. Rf3 Kg4 73. Qc8+ f5 0-1

  1.e4 c5 2.Nf3 Nc6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 d6 6.Bg5 e6 7.Qd2
  a6 8.O-O-O h6 9.Bf4 Bd7 10.Nxc6 Bxc6 11.f3 Qb6 12.Bc4 O-O-O
  13.Be3 Qc7 14.Qf2 Nd7 15.f4 b5 16.Be2 Qb7 17.a3 Be7 18.Bf3 Nf6
  19.e5 Ne4 20.Nxe4 Bxe4 21.Bxe4 Qxe4 22.Bb6 Rd7 23.Rhe1 Qb7
  24.exd6 Rxd6 25.Rxd6 Bxd6 26.Qd4 Bc7 27.Bxc7 Qxc7 28.Rd1 Rd8
  29.Qxd8+ Qxd8 30.Rxd8+ Kxd8 31.Kd2 Kd7 32.Kd3 Kd6 33.c4 bxc4
  34.Kxc4 e5 35.fxe5+ Kxe5 36.b4 f5 37.b5 axb5 38.Kxb5 f4 39.a4
  g5 40.a5 g4 41.Kc4 1-0

  1.Nf3 Nf6 2.c4 e6 3.Nc3 d5 4.d4 c6 5.Bg5 dxc4 6.e4 b5 7.a4 Qb6
  8.Bxf6 gxf6 9.Be2 a6 10.O-O Bb7 11.d5 cxd5 12.exd5 b4 13.a5
  Qc7 14.dxe6 bxc3 15.Nd4 Rg8 16.Qa4+ Kd8 17.g3 Bd5 18.Rfd1 Kc8
  19.bxc3 Bc5 20.e7 Nc6 21.Bg4+ Kb7 22.Nb5 Qe5 23.Re1 Be4
  24.Rab1 Rxg4 25.Rxe4 Qxe4 26.Nd6+ Kc7 27.Nxe4 Rxe4 28.Qd1 Re5
  29.Rb7+ Kxb7 30.Qd7+ Kb8 31.e8=Q+ Rxe8 32.Qxe8+ Kb7 33.Qd7+
  Kb8 34.Qxc6 1-0

  1.Nf3 g6 2.g3 Bg7 3.Bg2 e5 4.e4 Nc6 5.O-O d6 6.d3 Nge7 7.Nc3
  O-O 8.Nh4 Be6 9.Nd5 Bxd5 10.exd5 Nd4 11.c3 Ndf5 12.Nxf5 Nxf5
  13.Bd2 Bh6 14.b4 Bxd2 15.Qxd2 Ng7 16.Rae1 f5 17.d4 e4 18.f3
  exf3 19.Bxf3 Qd7 20.c4 Rae8 21.c5 Qd8 22.Kg2 Qf6 23.Bd1 Rxe1
  24.Rxe1 Re8 25.Rxe8+ Nxe8 26.h4 Qe7 27.Bf3 Nf6 28.Qc3 h6
  29.Qd3 Kg7 30.c6 b6 31.Qa3 g5 32.hxg5 hxg5 33.Kf2 g4 34.Bg2
  Nh5 35.Qxa7 Nxg3 36.Kxg3 Qe3+ 37.Kh2 Qf4+ 38.Kh1 g3 39.Qa6
  Qh6+ 40.Kg1 Qe3+ 41.Kh1 Qh6+ 1/2-1/2

  1.d4 Nf6 2.c4 c5 3.d5 e6 4.Nc3 exd5 5.cxd5 d6 6.Nf3 g6 7.e4
  Bg7 8.Bd3 O-O 9.O-O a6 10.a4 Bg4 11.h3 Bxf3 12.Qxf3 Nbd7
  13.Bf4 Qc7 14.Qe2 Rfe8 15.Bh2 Rac8 16.Bc4 Ne5 17.f4 Nxc4
  18.Qxc4 Nd7 19.Rfe1 Qb6 20.Rab1 Qb4 21.Qf1 c4 22.Re2 b5
  23.axb5 axb5 24.Kh1 Bxc3 25.bxc3 Qxc3 26.Rxb5 Qd3 27.Qe1 c3
  28.Rb1 Nc5 0-1

  1. e4 e5 2. Nf3 Nc6 3. Bb5 a6 4. Ba4 Nf6 5. O-O Be7 6. Re1 b5
  7. Bb3 O-O 8. c3 d6 9. h3 Nd7 10. d4 Nb6 11. Nbd2 exd4
  12. cxd4 d5 13. Bc2 Be6 14. e5 Qd7 15. Nb3 Bf5 16. Bg5 Bb4
  17. Re2 Rfe8 18. Rc1 Nc4 19. Na1 Bxc2 20. Qxc2 Re6 21. Qf5 h6
  22. Bf4 Rf8 23. b3 f6 24. Qg4 f5 25. Qh5 Nd6 26. Nc2 Ne4
  27. Nxb4 Nxb4 28. Ne1 c5 29. Rb2 cxd4 30. Qd1 g5 31. Bh2 Rc8
  32. Rxc8+ Qxc8 33. f3 Qc3 34. fxe4 Qxb2 35. exf5 Rc6 36. Bg3
  d3 37. Qh5 d2 38. Qe8+ Kg7 39. Qe7+ Kh8 40. f6 dxe1=Q+
  41. Bxe1 1-0

  1. c4 Nf6 2. Nc3 g6 3. g3 Bg7 4. Bg2 O-O 5. f4 c5 6. Nf3 d5
  7. cxd5 Nxd5 8. O-O Nc7 9. b3 Nc6 10. Bb2 Rb8 11. Na4 Bxb2
  12. Nxb2 b6 13. Nc4 Bb7 14. e3 Nd5 15. a3 e6 16. Qc2 Qe7
  17. g4 b5 18. Nce5 Nxe5 19. fxe5 Rbc8 20. a4 b4 21. Rf2 a5
  22. h4 Qc7 23. Qb2 c4 24. bxc4 Qxc4 25. Nd4 Ba8 26. Bf1 Qc5
  27. Nb3 Qc7 28. Ba6 Nxe3 29. Rc1 Qe7 30. dxe3 Qxh4 31. Kf1
  Qh3+ 32. Ke2 Qxg4+ 33. Kd2 Rfd8+ 34. Nd4 Qg3 35. Rf4 Rxc1
  36. Qxc1 Qg2+ 37. Be2 Qd5 38. Qc7 Rd7 39. Qc4 Kg7 40. Qxd5
  Bxd5 41. Bb5 Rc7 42. e4 Ba8 43. Ke3 Rc3+ 44. Bd3 b3 45. Rf1
  Rc5 46. Nxb3 Rxe5 47. Rc1 Rh5 48. Rc7 Kf6 49. Nc5 Ke5 50. Nd7+
  Kd6 51. Ra7 e5 52. Rxa8 Kxd7 53. Rxa5 Rh3+ 54. Kd2 Rh2+
  55. Kc3 h5 56. Ra7+ Kc6 57. Rxf7 g5 58. a5 g4 59. a6 Ra2
  60. Bc4 Ra1 61. Rf1 Rxf1 62. Bxf1 h4 63. Be2 g3 64. Bf1 1-0

  1.d4 Nf6 2.c4 e6 3.Nc3 Bb4 4.f3 d5 5.a3 Be7 6.e4 dxe4 7.fxe4
  e5 8.d5 Bc5 9.Bg5 a5 10.Nf3 Qe7 11.Bd3 Nbd7 12.Qe2 h6 13.Bd2
  c6 14.Na4 Bd4 15.Nxd4 exd4 16.Bf4 Ne5 17.Nb6 Bg4 18.Qc2 Nxd3+
  19.Qxd3 Ra6 20.O-O Rxb6 21.Bd6 Qxd6 22.e5 Qe7 23.Rae1 Nd7
  24.e6 fxe6 25.c5 Nxc5 26.Qg6+ Kd8 27.b4 axb4 28.Qxg4 cxd5
  29.Qg3 Nd7 30.axb4 Rf8 31.Rxf8+ Qxf8 32.b5 e5 33.Ra1 Kc7
  34.Rc1+ Kb8 35.Qb3 Nf6 36.Qc2 Qd8 37.Qa4 Ne4 38.Rf1 Nd6 39.Qa3
  Rxb5 40.Ra1 Qb6 0-1

  1. e4 c5 2. Nf3 d6 3. d4 cxd4 4. Nxd4 Nf6 5. Nc3 a6 6. Bc4 e6
  7. Bb3 b5 8. f4 b4 9. Na4 Nxe4 10. O-O g6 11. f5 gxf5 12. Nxf5
  Rg8 13. Bd5 Ra7 14. Bxe4 exf5 15. Bxf5 Re7 16. Bxc8 Qxc8
  17. Bf4 Qc6 18. Qf3 Qxa4 19. Bxd6 Qc6 20. Bxb8 Qb6+ 21. Kh1
  Qxb8 22. Qc6+ Rd7 23. Rae1+ Be7 24. Rxf7 Kxf7 25. Qe6+ Kf8
  26. Qxd7 Qd6 27. Qb7 Rg6 28. c3 a5 29. Qc8+ Kg7 30. Qc4 Bd8
  31. cxb4 axb4 32. g3 Qc6+ 33. Re4 Qxc4 34. Rxc4 Rb6 35. Kg2
  Kf6 36. Kf3 Ke5 37. Ke3 Bg5+ 38. Ke2 Kd5 39. Kd3 Bf6 40. Rc2
  Be5 41. Re2 Rf6 42. Rc2 Rf3+ 43. Ke2 Rf7 44. Kd3 Bd4 45. a3 b3
  46. Rc8 Bxb2 47. Rd8+ Kc6 48. Rb8 Rf3+ 49. Kc4 Rc3+ 50. Kb4
  Kc7 51. Rb5 Ba1 52. a4 b2 0-1

  1.e4 e5 2.Nf3 Nc6 3.Bb5 a6 4.Ba4 Nf6 5.O-O Be7 6.Re1 b5 7.Bb3
  d6 8.c3 O-O 9.h3 Nd7 10.d4 Nb6 11.Be3 exd4 12.cxd4 Na5 13.Bc2
  c5 14.e5 dxe5 15.Nxe5 Nbc4 16.Qd3 f5 17.Bb3 f4 18.Bd2 Nxb3
  19.Nc6 Nxa1 20.Nxd8 Bf5 21.Qf3 Raxd8 22.Rxe7 Bxb1 23.Bxf4 Rxd4
  24.Qg4 Bg6 25.Qe6+ Bf7 26.Qf5 Nc2 27.b3 Bg6 28.Rxg7+ Kxg7
  29.Bh6+ Kxh6 30.Qxf8+ Kg5 31.bxc4 bxc4 32.g3 Be4 33.h4+ Kg4
  34.Kh2 Bf5 35.Qf6 h6 36.Qe5 Re4 37.Qg7+ Kf3 38.Qc3+ Ne3 39.Kg1
  Bg4 40.fxe3 h5 41.Qe1 Rxe3 42.Qf1+ Ke4 43.Qxc4+ Kf3 44.Qf1+
  Ke4 45.Qxa6 Kd4 46.Qd6+ Kc4 47.a4 Re1+ 48.Kf2 Re2+ 49.Kf1 Ra2
  50.Qa6+ Kd4+ 51.a5 c4 52.Qb6+ Kd5 53.a6 Ra1+ 54.Kf2 c3 55.a7
  c2 56.Qb3+ Kd6 57.Qd3+ 1-0

  1.c4 e5 2.Nc3 Nf6 3.Nf3 d6 4.g3 g6 5.Bg2 Bg7 6.d3 O-O 7.Bd2
  Nh5 8.Qc1 f5 9.Bh6 Nc6 10.Bxg7 Kxg7 11.Nd5 f4 12.Qc3 Be6
  13.Nxf4 Nxf4 14.gxf4 Rxf4 15.h4 Qf6 16.Ng5 Nd4 17.e3 Rxf2
  18.exd4 Bg4 19.Bf3 Rxf3 20.O-O-O Qf4+ 21.Kb1 Qxd4 22.Qxd4 exd4
  23.Rhg1 Rg3 24.Rxg3 Bxd1 25.Kc1 Bh5 26.Ne6+ Kh6 27.Nxc7 Rf8
  28.Ne6 Rf1+ 29.Kc2 Rf2+ 30.Kc1 a6 31.Ng5 Rf4 32.Ne4 Bf3
  33.Nxd6 Kh5 34.Rg5+ Kxh4 35.Re5 h5 36.c5 g5 37.Nf5+ Rxf5
  38.Rxf5 Kg4 39.Rf8 h4 40.Rd8 h3 41.Rxd4+ Kg3 0-1

  1. e4 c5 2. Nf3 d6 3. d4 cxd4 4. Nxd4 Nf6 5. Nc3 a6 6. Bg5
  Nbd7 7. Bc4 Qa5 8. Qd2 e6 9. O-O Be7 10. Rad1 Nc5 11. Rfe1 Bd7
  12. a3 Qc7 13. b4 Na4 14. Nxa4 Bxa4 15. Bxe6 fxe6 16. Nxe6
  Qxc2 17. Qd4 Kf7 18. Rc1 Qa2 19. e5 dxe5 20. Qxe5 Qxf2+
  21. Kxf2 Ng4+ 22. Kg1 Nxe5 23. Rxe5 Bxg5 24. Nxg5+ Kg6 25. Ne6
  Rhe8 26. Re3 Rac8 27. Rf1 Bb5 28. Rg3+ Kh6 29. Nxg7 Rf8
  30. Re1 Rf6 31. h3 Rc2 32. Re4 Rc4 33. Re5 Rc1+ 34. Kh2 1-0

  1.d4 Nf6 2.c4 c5 3.d5 e6 4.Nc3 exd5 5.cxd5 d6 6.e4 g6 7.Nf3
  Bg7 8.Bg5 a6 9.a4 h6 10.Bf4 Bg4 11.Be2 O-O 12.O-O Re8 13.Qc2
  Qc7 14.Rfe1 Nbd7 15.h3 Bxf3 16.Bxf3 c4 17.Be2 Rac8 18.a5 Nc5
  19.Bxc4 Nfxe4 20.Nxe4 Rxe4 21.Rxe4 Nxe4 22.Qxe4 Qxc4 23.Qf3
  Qb4 24.Qg3 Qxb2 25.Re1 Qb5 26.Qf3 Bf8 27.h4 Qxa5 28.Rb1 b5
  29.h5 g5 30.Qg3 Qa2 31.Rd1 Qe2 32.Rd3 Bg7
  33.Qh3 Rc2 34.Bxd6 Rc1+ 35.Kh2 Qxf2 36.Rf3 Qg1+ 37.Kg3 Qe1+
  38.Kh2 Be5+ 39.Bxe5 Qxe5+ 40.Qg3 Qxd5 41.Rd3 Qc5 42.Qg4 Qe5+
  0-1

  1. e4 e5 2. Nf3 Nc6 3. Bb5 a6 4. Ba4 Nf6 5. O-O b5 6. Bb3 Be7
  7. c3 d6 8. Re1 O-O 9. h3 Na5 10. Bc2 c5 11. d4 Nc6 12. Nbd2
  Qb6 13. dxc5 dxc5 14. Nf1 Be6 15. Ne3 Rad8 16. Qe2 g6 17. Ng5
  c4 18. a4 Kg7 19. axb5 axb5 20. Rb1 Na5 21. Nf3 Qc7 22. Nd5
  Bxd5 23. exd5 Rfe8 24. Qxe5 Qxe5 25. Nxe5 Nxd5 26. Ra1 Nb3
  27. Bxb3 cxb3 28. Bh6+ Kg8 29. Nc6 Rc8 30. Rad1 Rxc6 31. Rxd5
  f6 32. Rxb5 g5 33. Rxb3 Kf7 34. Rb7 Re6 35. Rxe6 Kxe6 36. h4
  Rg8 37. f4 Bc5+ 38. Kf1 gxh4 39. Rb5 Rc8 40. f5+ Kd6 41. b4 h3
  42. Rxc5 h2 43. Bf4+ 1-0

  1.e4 c5 2.Nf3 d6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 Nc6 6.Bg5 e6 7.Qd2
  Be7 8.O-O-O O-O 9.Nb3 Qb6 10.f3 a6 11.g4 Rd8 12.Be3 Qc7 13.h4
  b5 14.g5 Nd7 15.g6 Nc5 16.gxf7 Kxf7 17.Bh3 Na4 18.f4 Nb4 19.f5
  e5 20.Nxa4 Nxa2+ 21.Kb1 bxa4 22.Na5 Rb8 23.Qd5+ Kf8 24.Kxa2
  Qxc2 25.Rd2 Rxb2+ 26.Ka1 Qc3 27.Qd3 1-0

  1.e4 c5 2.Nf3 d6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 Nc6 6.Bg5 e6 7.Qd2
  Be7 8.O-O-O O-O 9.Nb3 Qb6 10.f3 a6 11.g4 Rd8 12.Be3 Qc7 13.h4
  b5 14.g5 Nd7 15.g6 hxg6 16.h5 gxh5 17.Rxh5 Nf6 18.Rh1 d5 19.e5
  Nxe5 20.Bf4 Bd6 21.Qh2 Kf8 22.Qh8+ Ng8 23.Rh7 f5 24.Bh6 Rd7
  25.Bxb5 Rf7 26.Rg1 Ra7 27.Nd4 Ng4 28.fxg4 Be5 29.Nc6 Bxc3
  30.Be3 d4 31.Rgh1 Rd7 32.Bg5 axb5 33.R1h6 d3 34.bxc3 d2 35.Kd1
  Qxc6 36.Rf6+ Rf7 37.Qxg7+ 1-0

  1.e4 c5 2.Nf3 d6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 a6 6.Bg5 e6 7.f4
  b5 8.Qf3 Bb7 9.Bd3 Be7 10.O-O-O Qb6 11.Rhe1 Nbd7 12.Nce2 Nc5
  13.Bxf6 Bxf6 14.g4 Na4 15.c3 b4 16.Bc2 Nxb2 17.Kxb2 bxc3
  18.Kxc3 O-O 19.Rb1 Qa5+ 20.Kd3 Rac8 21.Qf2 Ba8 22.Rb3 e5 23.g5
  exd4 24.Nxd4 Bxd4 0-1

  1. d4 Nf6 2. c4 g6 3. Nc3 Bg7 4. e4 d6 5. Be2 O-O 6. Nf3 e5
  7. d5 Nbd7 8. Bg5 h6 9. Bh4 a6 10. Nd2 Qe8 11. O-O Nh7 12. b4
  Ng5 13. f3 f5 14. Bf2 Qe7 15. Rc1 Nf6 16. c5 Bd7 17. Qc2 Nh5
  18. b5 fxe4 19. Ndxe4 Nxe4 20. fxe4 Nf4 21. c6 Qg5 22. Bf3
  bxc6 23. dxc6 Bg4 24. Bxg4 Qxg4 25. Be3 axb5 26. Bxf4 exf4
  27. Nxb5 Rf7 28. Qc4 Rc8 29. Rf3 Be5 30. Rcf1 Kg7 31. a4 Ra8
  32. Kh1 Qg5 33. g3 Raf8 34. gxf4 Bxf4 35. Nd4 Qh4 36. Rxf4
  Rxf4 37. Ne6+ Kh8 38. Qd4+ R8f6 39. Nxf4 Kh7 40. e5 dxe5
  41. Qd7+ 1-0

  1.e4 c6 2.d3 d5 3.Nd2 e5 4.Ngf3 Nd7 5.d4 dxe4 6.Nxe4 exd4
  7.Qxd4 Ngf6 8.Bg5 Be7 9.O-O-O O-O 10.Nd6 Qa5 11.Bc4 b5 12.Bd2
  Qa6 13.Nf5 Bd8 14.Qh4 bxc4 15.Qg5 Nh5 16.Nh6+ Kh8 17.Qxh5 Qxa2
  18.Bc3 Nf6 19.Qxf7 Qa1+ 20.Kd2 Rxf7 21.Nxf7+ Kg8 22.Rxa1 Kxf7
  23.Ne5+ Ke6 24.Nxc6 Ne4+ 25.Ke3 Bb6+ 26.Bd4 1-0

  1.d4 Nf6 2.c4 e6 3.Nf3 b6 4.Nc3 Bb7 5.Bg5 Bb4 6.e3 h6 7.Bh4 g5
  8.Bg3 Ne4 9.Qc2 Bxc3+ 10.bxc3 d6 11.Bd3 Nxg3 12.hxg3 Nd7 13.a4
  a5 14.Rb1 g4 15.Nh4 Nf6 16.d5 Qe7 17.O-O Nd7 18.dxe6 Qxe6
  19.Bf5 Qxc4 20.Rfd1 Nf6 21.Rd4 Qc6 22.Be6 Rg8 23.Bc4 Kf8
  24.Bb5 Qc5 25.Rc4 Qe5 26.Rxc7 Be4 27.Bd3 d5 28.Rc6 Rb8 29.c4
  Rg5 30.c5 d4 31.exd4 Qxd4 32.Bxe4 Qxe4 33.cxb6 Qxc2 34.Rxc2
  Nd7 35.b7 Nc5 36.Rb5 Nxb7 37.Rcb2 Rxb5 38.Rxb5 Ke7 39.Nf5+ Kd7
  40.Nxh6 Kc7 41.Nxf7 Rf8 42.Nh6 Rd8 43.Rg5 Rd1+ 44.Kh2 Ra1
  45.Rxg4 Nc5 46.Rc4 Kc6 47.Nf5 Rxa4 48.Nd4+ Kb6 49.Rxa4 Nxa4
  50.g4 Nc3 51.Kg3 a4 52.Kf4 a3 53.Nc2 a2 54.g5 Kc5 55.g6 Nd5+
  56.Kg5 Kc4 57.g7 Ne7 58.f4 Kc3 59.Na1 Kb2 60.f5 Kxa1 61.f6 Kb1
  62.fxe7 a1=Q 63.e8=Q Qa5+ 64.Kh6 1-0

  1. d4 Nf6 2. c4 g6 3. Nc3 Bg7 4. e4 d6 5. Be2 O-O 6. Nf3 e5
  7. d5 Nbd7 8. Bg5 h6 9. Bh4 a6 10. O-O Qe8 11. Nd2 Nh7 12. b4
  Bf6 13. Bxf6 Nhxf6 14. Nb3 Qe7 15. Qd2 Kh7 16. Qe3 Ng8 17. c5
  f5 18. exf5 gxf5 19. f4 exf4 20. Qxf4 dxc5 21. Bd3 cxb4
  22. Rae1 Qf6 23. Re6 Qxc3 24. Bxf5+ Rxf5 25. Qxf5+ Kh8 26. Rf3
  Qb2 27. Re8 Nf6 28. Qxf6+ Qxf6 29. Rxf6 Kg7 30. Rff8 Ne7
  31. Na5 h5 32. h4 Rb8 33. Nc4 b5 34. Ne5 1-0

  1.d4 Nf6 2.c4 e6 3.Nf3 c5 4.d5 exd5 5.cxd5 g6 6.Nc3 Bg7 7.Bg5
  O-O 8.e3 Re8 9.Nd2 d6 10.Be2 a6 11.a4 Nbd7 12.O-O Qc7 13.Qc2
  Nb6 14.Bf3 c4 15.Bxf6 Bxf6 16.a5 Nd7 17.Nce4 Be5 18.Qxc4 Qd8
  19.Qa2 f5 20.Nc3 g5 21.Nc4 g4 22.Be2 Qf6 23.Na4 Kh8 24.g3 h5
  25.f4 Bd4 26.Qa3 Rb8 27.Nab6 h4 28.Rad1 Bxb6 29.axb6 Nc5
  30.gxh4 Bd7 31.Qc3 Qxc3 32.bxc3 Bb5 33.Rfe1 Ne4 34.Rc1 Rbc8
  35.Na5 Bxe2 36.Rxe2 Nxc3 37.Rxc3 Rxc3 38.Nxb7 Rexe3 39.Rxe3
  Rxe3 40.Nxd6 Rd3 41.Nf7+ 1-0

  1.c4 f5 2.Nf3 Nf6 3.g3 g6 4.Bg2 Bg7 5.d4 d6 6.Nc3 e6 7.O-O O-O
  8.Qc2 Nc6 9.Rd1 Qe7 10.Rb1 a5 11.a3 Nd8 12.e4 fxe4 13.Nxe4
  Nxe4 14.Qxe4 Nf7 15.Bh3 Qf6 16.Bd2 d5 17.Qe2 dxc4 18.Bf4 Nd6
  19.Ng5 Re8 20.Bg2 Ra6 21.Ne4 Nxe4 22.Bxe4 b5 23.b3 cxb3
  24.Qxb5 Rf8 25.Qxb3 Rb6 26.Qe3 Rxb1 27.Bxb1 Bb7 28.Ba2 Bd5
  29.Bxd5 exd5 30.Bxc7 a4 31.Rd3 Qf5 32.Be5 Bh6 33.Qe2 Rc8
  34.Rf3 Qh3 35.Bc7 Bf8 36.Qb5 Qe6 37.Be5 Qc6 38.Qa5 Ra8 39.Qd2
  Rc8 40.Kg2 Qd7 41.h4 Qg4 1-0

  1.e4 c6 2.d4 d5 3.Nc3 dxe4 4.Nxe4 Bf5 5.Ng3 Bg6 6.Bc4 e6
  7.N1e2 Nf6 8.Nf4 Bd6 9.Nxg6 hxg6 10.Bg5 Nbd7 11.O-O Qa5 12.f4
  O-O-O 13.a3 Qc7 14.b4 Nb6 15.Be2 Be7 16.Qd3 Nfd5 17.Bxe7 Qxe7
  18.c4 Nf6 19.Rab1 Qd7 20.Rbd1 Kb8 21.Qb3 Qc7 22.a4 Rh4 23.a5
  Nc8 24.Qe3 Ne7 25.Qe5 Rhh8 26.b5 cxb5 27.Qxb5 a6 28.Qb2 Rd7
  29.c5 Ka8 30.Bf3 Nc6 31.Bxc6 Qxc6 32.Rf3 Qa4 33.Rfd3 Rc8
  34.Rb1 Qxa5 35.Rb3 Qc7 36.Qa3 Ka7 37.Rb6 Qxf4 38.Ne2 Qe4
  39.Qb3 Qd5 40.Rxa6+ Kb8 41.Qa4 1-0

  1.e4 c6 2.d4 d5 3.Nc3 dxe4 4.Nxe4 Bf5 5.Ng3 Bg6 6.N1e2 Nf6
  7.h4 h6 8.Nf4 Bh7 9.Bc4 e6 10.O-O Bd6 11.Nxe6 fxe6 12.Bxe6 Qc7
  13.Re1 Nbd7 14.Bg8 Kf8 15.Bxh7 Rxh7 16.Nf5 g6 17.Bxh6+ Kg8
  18.Nxd6 Qxd6 19.Bg5 Re7 20.Qd3 Kg7 21.Qg3 Rxe1+ 22.Rxe1 Qxg3
  23.fxg3 Rf8 24.c4 Ng4 25.d5 cxd5 26.cxd5 Ndf6 27.d6 Rf7 28.Rc1
  Rd7 29.Rc7 Kf7 30.Bxf6 Nxf6 31.Kf2 Ke6 32.Rxd7 Kxd7 33.Kf3
  Kxd6 34.Kf4 Ke6 35.g4 Nd5+ 36.Ke4 Nf6+ 37.Kf4 Nd5+ 38.Ke4 Nb4
  39.a3 Nc6 40.h5 g5 41.h6 Kf6 42.Kd5 Kg6 43.Ke6 Na5 44.a4 Nb3
  45.Kd6 a5 46.Kd5 Kxh6 47.Kc4 Nc1 48.Kb5 Nd3 49.b3 Nc1 50.Kxa5
  Nxb3+ 51.Kb4 Nc1 52.Kc3 Kg6 53.Kc2 Ne2 54.Kd3 Nc1+ 55.Kc2 Ne2
  56.Kd3 Nf4+ 57.Kc4 Kf6 58.g3 Ne2 0-1

  1.e4 e5 2.Nf3 Nc6 3.Bb5 Nf6 4.O-O d6 5.d4 Bd7 6.Nc3 exd4
  7.Nxd4 Be7 8.Bxc6 bxc6 9.Qf3 O-O 10.e5 Ng4 11.Nxc6 Nxe5
  12.Nxe5 dxe5 13.Rd1 Qc8 14.Qe2 f6 15.Be3 Be6 16.f3 a6 17.Ne4
  Re8 18.Nf2 Qb7 19.b3 Qc6 20.Nd3 Bd6 21.Qf2 Bf5 22.Re1 e4
  23.fxe4 Bxe4 24.Rad1 Bg6 25.c4 Rad8 26.Nf4 Bb4 27.Rf1 Rxd1
  28.Rxd1 Qe4 29.Nd5 Bd6 30.Bf4 Bh5 31.Rf1 Bxf4 32.Qxf4 c5
  33.Qxe4 Rxe4 34.Rxf6 Re1+ 35.Rf1 Re5 36.Rf5 Rxf5 37.Ne7+ Kf8
  38.Nxf5 Bg6 39.Nd6 Bb1 40.Nb7 Bxa2 41.Nxc5 Ke7 42.Kf2 a5
  43.Ke3 a4 44.bxa4 Bxc4 45.Kd4 Bf1 46.g3 Kd6 47.Ne4+ Kc6 48.Ng5
  1-0

  1.c4 Nf6 2.Nc3 e6 3.d4 Bb4 4.a3 Bxc3+ 5.bxc3 b6 6.f3 Ba6 7.e4
  d5 8.cxd5 Bxf1 9.Kxf1 exd5 10.Bg5 h6 11.Qa4+ c6 12.Bh4 dxe4
  13.Re1 g5 14.Bf2 Qe7 15.Ne2 b5 16.Qc2 Qxa3 17.h4 gxh4 18.Bxh4
  Nbd7 19.Ng3 O-O-O 20.Nxe4 Rhe8 21.Kf2 Nxe4+ 22.fxe4 f6 23.Ra1
  Qe7 24.Rxa7 Qxe4 25.Qxe4 Rxe4 26.Ra8+ Nb8 27.Bg3 Kb7 28.Rha1
  Rc8 29.R8a7+ Kb6 30.Bxb8 b4 31.Bd6 bxc3 32.Bc5+ Kb5 33.R1a4
  1-0

  1.e4 c6 2.d4 d5 3.e5 c5 4.dxc5 e6 5.Qg4 Nc6 6.Nf3 Qc7 7.Bb5
  Bd7 8.Bxc6 Qxc6 9.Be3 Nh6 10.Bxh6 gxh6 11.Nbd2 Qxc5 12.c4
  O-O-O 13.O-O Kb8 14.Rfd1 Qb6 15.Qh4 a5 16.Rac1 Rg8 17.Nb3 a4
  18.c5 Qc7 19.Nbd4 Rc8 20.b4 axb3 21.axb3 Qd8 22.Qxd8 Rxd8
  23.b4 Rg4 24.b5 Rc8 25.c6 Be8 26.Rc2 Bg7 27.Ra1 Bxe5 28.Nxe5
  Rxd4 29.Nd7+ 1-0

  1.d4 Nf6 2.c4 d6 3.Nc3 g6 4.e4 Bg7 5.f3 O-O 6.Be3 a6 7.Qd2 c6
  8.Bd3 e5 9.dxe5 dxe5 10.Na4 b5 11.Nb6 Ra7 12.Bc2 Be6 13.Qxd8
  Rxd8 14.Ne2 Rb7 15.c5 a5 16.Kf2 Bf8 17.Rad1 Rxd1 18.Rxd1 Nfd7
  19.Nxd7 Nxd7 20.Bb1 Bxc5 21.Bxc5 Nxc5 22.Rc1 Na6 23.f4 exf4
  24.Nxf4 c5 25.Ke3 Kf8 26.e5 Ke7 27.Be4 Rc7 28.a4 bxa4 29.Ra1
  Bb3 30.Nd5+ Bxd5 31.Bxd5 Rd7 32.Bc4 Nb4 33.Rxa4 Rd4 34.Bb5 Ke6
  35.Rxa5 Nd5+ 36.Kf2 Kxe5 37.Be2 Kd6 38.Ra6+ Kd7 39.Ra7+ Nc7
  40.b3 Rd2 41.Kf3 f5 42.h4 Kc6 43.Bc4 h6 44.g3 Rd4 45.Kf2 g5
  46.hxg5 hxg5 47.Ra2 g4 48.Ra1 Kb6 49.Re1 Nb5 50.Re6+ Nd6
  51.Ke3 Kc7 52.Bd3 Kc6 53.Bc2 Rb4 54.Rf6 Kd5 55.Rf8 Ke5 56.Ra8
  Ne4 57.Re8+ Kd5 58.Rd8+ Ke6 59.Kf4 Nd2 60.Ke3 Nxb3 61.Re8+
  Kd7+ 62.Re5 Kd6 63.Rxf5 Nd4 64.Rf2 Nxc2+ 65.Rxc2 Kd5 66.Rh2
  Re4+ 67.Kd2 c4 68.Rh8 Rd4+ 69.Ke3 Rd3+ 70.Kf4 c3 71.Rd8+ Kc4
  72.Rc8+ Kb3 73.Rb8+ Ka2 74.Rc8 Kb2 75.Rb8+ Kc1 0-1

  1.e4 c5 2.Nf3 d6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 a6 6.Be2 e5 7.Nb3
  Be7 8.Bg5 Be6 9.O-O O-O 10.Bxf6 Bxf6 11.Qd3 Nc6 12.Nd5 Bg5
  13.Rfd1 Kh8 14.c3 f5 15.Bf3 Bxd5 16.Qxd5 fxe4 17.Qxe4 Qe7
  18.Qd5 Rf6 19.Nd2 Bxd2 20.Rxd2 Qc7 21.Re1 Raf8 22.Re3 g6
  23.Be4 Kg7 24.Rf3 Rxf3 25.Bxf3 Rf6 26.Be4 Qf7 27.Qb3 Qxb3
  28.axb3 Nd8 29.b4 Kf7 30.Rd5 Ke8 31.b5 axb5 32.Rxb5 Rf7 33.Rb6
  Kd7 34.Bd5 Rf4 35.g3 Ra4 36.Bxb7 Ra1+ 37.Kg2 Kc7 38.Ra6 Rb1
  39.Bd5 Rxb2 40.Ra7+ Nb7 41.Kf3 Kb8 42.Ra6 Kc7 43.Ra8 Nc5
  44.Ra7+ Nb7 45.h4 Kb8 46.Ra6 Kc7 47.Ra8 Rb5 48.c4 Rb3+ 49.Kg4
  1-0

  1. e4 e5 2. Nf3 Nc6 3. Bb5 a6 4. Ba4 Nf6 5. O-O Be7 6. Re1 b5
  7. Bb3 d6 8. c3 O-O 9. h3 Na5 10. Bc2 c5 11. d4 Qc7 12. Nbd2
  Nc6 13. dxc5 dxc5 14. Nf1 Rd8 15. Qe2 Rb8 16. Ne3 g6 17. Ng5
  Bf8 18. Qf3 Bg7 19. Nd5 Qd6 20. Be3 h6 21. Nxf6+ Bxf6 22. Rad1
  Qe7 23. Bxc5 Rxd1 24. Rxd1 Qxc5 25. Qxf6 hxg5 26. Bb3 Rb7
  27. Qxg6+ Kf8 28. Qh6+ Ke7 29. Rd5 Qb6
  30. Rd6 Rc7 31. Qf6+ Ke8 32. Rd8+ 1-0

  1.e4 e6 2.d3 d5 3.Nd2 Nf6 4.Ngf3 Nc6 5.g3 dxe4 6.dxe4 Bc5
  7.Bg2 e5 8.O-O O-O 9.Qe2 Be6 10.c3 a5 11.Nc4 Nd7 12.Ng5 Bxc4
  13.Qxc4 Qe7 14.Bd2 Rad8 15.Rad1 Nb6 16.Qe2 Rd6 17.Bh3 Rxd2
  18.Qxd2 Rd8 19.Qc1 Rxd1 20.Rxd1 Qf6 21.Bf5 g6 22.b4 axb4
  23.cxb4 Be7 24.Bd7 Nd4 25.Qxc7 Bd8 26.Qxb7 Qxg5 27.Be8 Qf6
  28.a4 Kf8 29.Bb5 Qd6 30.Rc1 Nxa4 31.Kg2 Nb6 32.Rc5 Qf6 33.Qb8
  Qf3+ 34.Kg1 Qd1+ 35.Kg2 Qf3+ 36.Kg1 Ne6 37.Rc6 Qd1+ 38.Kg2 Qd4
  39.Rd6 Qxe4+ 40.Kg1 Qb1+ 41.Kg2 1/2-1/2

  1.e4 e6 2.d4 d5 3.Nc3 Bb4 4.e5 c5 5.a3 Bxc3+ 6.bxc3 Qc7 7.Qg4
  f5 8.Qg3 Ne7 9.Qxg7 Rg8 10.Qxh7 cxd4 11.Kd1 Bd7 12.Qh5+ Ng6
  13.Ne2 d3 14.cxd3 Ba4+ 15.Ke1 Qxe5 16.Bg5 Nc6 17.d4 Qc7 18.h4
  e5 19.Rh3 Qf7 20.dxe5 Ncxe5 21.Re3 Kd7 22.Rb1 b6 23.Nf4 Rae8
  24.Rb4 Bc6 25.Qd1 Nxf4 26.Rxf4 Ng6 27.Rd4 Rxe3+ 28.fxe3 Kc7
  29.c4 dxc4 30.Bxc4 Qg7 31.Bxg8 Qxg8 32.h5 1-0

  1.c4 Nf6 2.Nf3 g6 3.g3 Bg7 4.Bg2 O-O 5.d4 d6 6.Nc3 Nbd7 7.O-O
  e5 8.e4 c6 9.h3 Qb6 10.d5 cxd5 11.cxd5 Nc5 12.Ne1 Bd7 13.Nd3
  Nxd3 14.Qxd3 Rfc8 15.Rb1 Nh5 16.Be3 Qb4 17.Qe2 Rc4 18.Rfc1
  Rac8 19.Kh2 f5 20.exf5 Bxf5 21.Ra1 Nf4 22.gxf4 exf4 23.Bd2
  Qxb2 24.Rab1 f3 25.Rxb2 fxe2 26.Rb3 Rd4 27.Be1 Be5+ 28.Kg1 Bf4
  29.Nxe2 Rxc1 30.Nxd4 Rxe1+ 31.Bf1 Be4 32.Ne2 Be5 33.f4 Bf6
  34.Rxb7 Bxd5 35.Rc7 Bxa2 36.Rxa7 Bc4 37.Ra8+ Kf7 38.Ra7+ Ke6
  39.Ra3 d5 40.Kf2 Bh4+ 41.Kg2 Kd6 42.Ng3 Bxg3 43.Bxc4 dxc4
  44.Kxg3 Kd5 45.Ra7 c3 46.Rc7 Kd4 47.Rd7+ 0-1

  1.e4 c5 2.Nf3 e6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 d6 6.g3 a6 7.Bg2
  Qc7 8.O-O Be7 9.f4 Nc6 10.Nxc6 bxc6 11.e5 dxe5 12.fxe5 Nd7
  13.Bf4 O-O 14.Ne4 Bb7 15.Qh5 g6 16.Qe2 c5 17.Nf6+ Bxf6 18.exf6
  e5 19.Bxe5 Nxe5 20.Bxb7 Rab8 21.Bd5 Rb6 22.Rae1 Nd7 23.Qe7 c4
  24.Kh1 Rxb2 25.Re6 Rbb8 26.Rd6 Rbd8 27.Rd1 1-0

  1. e4 e6 2. d4 d5 3. Nc3 Bb4 4. e5 c5 5. a3 Ba5 6. b4 cxd4
  7. Qg4 Ne7 8. bxa5 dxc3 9. Qxg7 Rg8 10. Qxh7 Nbc6 11. Nf3 Qc7
  12. Bb5 Bd7 13. O-O O-O-O 14. Bg5 Nxe5 15. Nxe5 Bxb5 16. Nxf7
  Bxf1 17. Nxd8 Rxg5 18. Nxe6 Rxg2+ 19. Kh1 Qe5 20. Rxf1 Qxe6
  21. Kxg2 Qg4+ 1/2-1/2

  1.e4 e6 2.d4 d5 3.e5 c5 4.c3 Nc6 5.Nf3 Qb6 6.Bd3 cxd4 7.cxd4
  Bd7 8.O-O Nxd4 9.Nxd4 Qxd4 10.Nc3 Qb6 11.Qg4 h5 12.Qg5 g6
  13.a4 Bh6 14.Qh4 a6 15.Bxh6 Nxh6 16.Qf6 Rf8 17.Nxd5 Qd8 18.Qf4
  exd5 19.Qxh6 Qe7 20.Qe3 Bc6 21.Rac1 Rg8 22.f4 Kf8 23.f5 gxf5
  24.Qh6+ Rg7 25.Rxf5 Bd7 26.Rc7 Qe6 27.Qh8+ Rg8 28.Qxh5 Rc8
  29.Rxc8+ Bxc8 30.Rf6 Qe7 31.Qh6+ Rg7 32.Rd6 Qxe5 33.Qh8+ 1-0

  1.e4 e5 2.Nf3 Nc6 3.Bb5 a6 4.Ba4 Nf6 5.O-O Be7 6.Re1 b5 7.Bb3
  d6 8.c3 O-O 9.h3 Nb8 10.d4 Nbd7 11.c4 c6 12.c5 Qc7 13.cxd6
  Bxd6 14.Bg5 c5 15.dxc5 Bxc5 16.Nc3 Bb7 17.Rc1 Qb6 18.Re2 Rfe8
  19.Nd5 Bxd5 20.Bxd5 Rad8 21.Rec2 Be7 22.Rc6 Qa5 23.Bd2 b4
  24.Bxf7+ Kxf7 25.Qb3+ Kf8 1-0

  1.c4 e5 2.Nc3 d6 3.g3 f5 4.d4 e4 5.f3 Nf6 6.Bg2 exf3 7.Nxf3 g6
  8.O-O Bg7 9.e4 fxe4 10.Ng5 O-O 11.Ngxe4 Nxe4 12.Rxf8+ Qxf8
  13.Nxe4 Nc6 14.Be3 Bf5 15.Qd2 Re8 16.Ng5 Rxe3 17.Bd5+ Kh8 18.Nf7+ Qxf7 19.Bxf7 Rd3 20.Qe2 Bxd4+ 21.Kg2 Ne5
  22.Rd1 Re3 23.Qf1 Be4+ 24.Kh3 Rf3 25.Qe2 Bf5+ 0-1

  1.d4 Nf6 2.c4 g6 3.Nc3 Bg7 4.e4 d6 5.Nf3 O-O 6.Be2 e5 7.dxe5
  dxe5 8.Qxd8 Rxd8 9.Nd5 Rd7 10.Nxf6+ Bxf6 11.c5 Nc6 12.Bb5 Rd8
  13.Bxc6 bxc6 14.O-O Bg4 15.Be3 Rab8 16.b3 Bg7 17.h3 Bxf3
  18.gxf3 f5 19.Rad1 Kf7 20.Bg5 Bf6 21.Bxf6 Kxf6 22.Rfe1 Rd4
  23.Rxd4 exd4 24.exf5 gxf5 25.f4 d3 26.Kg2 d2 27.Rd1 Rd8 28.Kf3
  Kg6 29.b4 Kh5 30.Kg3 Kg6 31.f3 Kh5 32.a3 Rd4 33.Kf2 Kh4 34.Kg2
  Rd3 35.Kf2 h5 36.Kg2 Rxa3 37.Rxd2 Rb3 38.Ra2 Rxb4 39.Rxa7 Rb2+
  40.Kf1 Rc2 41.Rxc7 Rxc5 42.Kf2 Kxh3 43.Rg7 h4 44.Rg5 Ra5
  45.Rh5 Ra2+ 46.Ke3 Kg2 47.Rxh4 Ra3+ 48.Ke2 Rxf3 49.Rh5 Rxf4
  50.Rg5+ Kh3 51.Ke3 Rf1 52.Ke2 Kh4 53.Rg6 Rc1 54.Kf3 Rc4 55.Ke3
  c5 56.Kf3 Rg4 57.Rc6 c4 58.Rc5 Kg5 59.Rc6 Re4 60.Rc8 Kf6
  61.Rc5 Ke6 62.Kg2 f4 63.Kf3 Rd4 64.Rc7 Kd5 65.Rc8 Rd3+ 66.Kxf4
  c3 67.Rc7 Kd4 68.Rc8 Rd2 0-1

  1.e4 c5 2.Nf3 Nc6 3.d4 cxd4 4.Nxd4 e6 5.Nc3 Qc7 6.Be3 a6 7.a3
  Nf6 8.f4 d6 9.Qf3 Be7 10.Bd3 O-O 11.O-O Bd7 12.Rae1 b5 13.Qg3
  Kh8 14.Nxc6 Bxc6 15.e5 Ng8 16.Qh3 Nh6 17.f5 Nxf5 18.Rxf5 exf5
  19.Bxf5 g6 20.Bd4 Kg8 21.e6 Bg5 22.exf7 Rxf7 23.Bxg6 Rg7
  24.Qe6+ Kh8 25.Be8 h6 26.Bxc6 Qxc6 27.Ne4 Re8 28.Qg6 Re7 29.h4
  Qd5 30.Bxg7+ Rxg7 31.Qxd6 Qxd6 32.Nxd6 Bxh4 33.Re8+ Rg8
  34.Nf7+ Kg7 35.Rxg8+ Kxg8 36.Nxh6+ Kh7 37.Nf5 Bg5 38.b3 1-0

  1.d4 Nf6 2.c4 e6 3.Nc3 Bb4 4.a3 Bxc3+ 5.bxc3 d6 6.f3 e5 7.e4
  O-O 8.Bg5 Re8 9.Ne2 h6 10.Be3 c5 11.d5 Nh5 12.g4 Nf4 13.Qd2 g5
  14.Ng3 Qf6 15.h4 Na6 16.Ra2 Kf8 17.hxg5 hxg5 18.Qc1 Ke7 19.Nh5
  Qg6 20.Rah2 Rg8 21.Ng3 Nc7 22.Rh7 Qf6 23.Qd2 Bd7 24.R1h6 Rg6
  25.Nh5 Rxh6 26.Nxf6 Rxf6 27.Rg7 Rh8 28.Rxg5 Ne8 29.Qf2 Rh1
  30.Bxf4 Rxf4 31.Rh5 Rxh5 32.gxh5 Nf6 33.Qh2 Rxf3 34.h6 Nh7
  35.Qg2 Rf4 36.Qg7 Rxe4+ 37.Kd2 Bf5 38.Bd3 Nf6 39.Bxe4 Nxe4+
  40.Ke1 Nf6 41.Qh8 a5 1-0

  1.d4 Nf6 2.c4 g6 3.g3 Bg7 4.Bg2 O-O 5.Nf3 d6 6.O-O Nbd7 7.Nc3
  e5 8.e4 c6 9.h3 Qb6 10.dxe5 dxe5 11.a3 Qc5 12.Qe2 Qe7 13.Be3
  Nc5 14.Qc2 Nh5 15.b4 Ne6 16.Rad1 f5 17.exf5 gxf5 18.Ne2 f4
  19.Bc1 Ng5 20.Nxg5 Qxg5 21.g4 Nf6 22.Nc3 Be6 23.Qe2 Rad8
  24.Rfe1 Rxd1 25.Rxd1 h5 26.f3 hxg4 27.hxg4 Nxg4 28.Rd6 Qe7
  29.Rxe6 Qxe6 30.fxg4 e4 31.Nxe4 Bd4+ 32.Kf1 f3 33.Bxf3 Qxg4
  34.Nf6+ Rxf6 35.Qe8+ Kh7 36.Qe7+ Qg7 37.Qxg7+ Kxg7 38.Ke2 b6
  39.Bd2 c5 40.bxc5 bxc5 41.a4 Rb6 42.Bd5 Kf6 43.Kd3 Ke5 44.Be1
  Rb3+ 45.Kc2 Ra3 46.a5 Ba1 47.Bf7 Ke4 48.Bg6+ Kd4+ 49.Bf7 Ra2+
  50.Kb3 Rb2+ 51.Ka3 Kd3 52.Bg3 Rb4 53.Bd6 Bd4 54.Bd5 Kc2
  55.Be4+ Kc3 56.Bd5 Rb3+ 0-1

  1.e4 c5 2.Nf3 Nc6 3.d4 cxd4 4.Nxd4 g6 5.c4 Nf6 6.Nc3 Nxd4
  7.Qxd4 d6 8.Be2 Bg7 9.Be3 O-O 10.Qd2 Be6 11.Rc1 Qa5 12.b3 Rfc8
  13.O-O a6 14.f4 b5 15.f5 Bd7 16.fxg6 hxg6 17.c5 Be6 18.Bf3
  dxc5 19.e5 Ng4 20.Bxa8 Bxe5 21.Bd5 Nxe3 22.Bxe6 Rd8 23.Qf2 Nf5
  24.Qe2 Bd4+ 25.Kh1 fxe6 26.Qxe6+ Kg7 27.Ne4 Qc7 28.Ng5 Rf8
  29.Qxf5 1-0

  1. e4 c5 2. Nf3 d6 3. d4 cxd4 4. Nxd4 Nf6 5. Nc3 a6 6. Be2 e5
  7. Nb3 Be6 8. O-O Nbd7 9. a4 Be7 10. f4 Qc7 11. Be3 O-O 12. a5
  b5 13. axb6 Nxb6 14. f5 Bc4 15. Bxb6 Qxb6+ 16. Kh1 Bb5
  17. Bxb5 axb5 18. Nd5 Nxd5 19. Qxd5 Ra4 20. c3 Qa6 21. Rad1
  Rc8 22. Nc1 b4 23. Nd3 bxc3 24. bxc3 Ra5 25. Qb3 Ra3 26. Qb1
  Raxc3 27. Nb4 Qa7 28. Nd5 R3c6 29. Qb3 Bf8 30. h3 Ra6 31. Rb1
  Ra3 32. Qb5 Qd4 33. Rfe1 Rg3 34. Qe2 Qd3 35. Qh5 Qc2 36. Qe2
  Qxe2 37. Rxe2 h5 38. Ra2 Rd3 39. Ra7 h4 40. f6 g6 41. Kh2 Rxd5
  42. exd5 Bh6 43. Re7 Bg5 44. Rf1 Bf4+ 45. Kg1 g5 46. Rb1 e4
  47. Rxe4 Kh7 48. Re7 Kg6 49. Rbb7 Kxf6 50. Rxf7+ Ke5 51. Rfc7
  Ra8 52. Rb1 Kxd5 53. Rd1+ Ke6 54. Rc2 Ra3 55. Kf2 Rb3 56. Re2+
  Kf5 57. Rd5+ Kf6 58. Re4 1/2-1/2

  1.d4 Nf6 2.c4 e6 3.Nf3 b6 4.Nc3 Bb4 5.Bg5 Bb7 6.e3 h6 7.Bh4
  Bxc3+ 8.bxc3 d6 9.Nd2 e5 10.f3 Qe7 11.e4 Nbd7 12.Bd3 Nf8 13.c5
  dxc5 14.dxe5 Qxe5 15.Qa4+ c6 16.O-O Ng6 17.Nc4 Qe6 18.e5 b5
  19.exf6 bxa4 20.fxg7 Rg8 21.Bf5 Nxh4 22.Bxe6 Ba6 23.Nd6+ Ke7
  24.Bc4 Rxg7 25.g3 Kxd6 26.Bxa6 Nf5 27.Rab1 f6 28.Rfd1+ Ke7
  29.Re1+ Kd6 30.Kf2 c4 31.g4 Ne7 32.Rb7 Rag8 33.Bxc4 Nd5
  34.Bxd5 cxd5 35.Rb4 Rc8 36.Rxa4 Rxc3 37.Ra6+ Kc5 38.Rxf6 h5
  39.h3 hxg4 40.hxg4 Rh7 41.g5 Rh5 42.Rf5 Rc2+ 43.Kg3 Kc4
  44.Ree5 d4 45.g6 Rh1 46.Rc5+ Kd3 47.Rxc2 Kxc2 48.Kf4 Rg1
  49.Rg5 1-0

  1.d4 Nf6 2.c4 c5 3.d5 e6 4.Nc3 exd5 5.cxd5 d6 6.e4 g6 7.f4 Bg7
  8.Bb5+ Nfd7 9.a4 O-O 10.Nf3 Na6 11.O-O Nb4 12.Be3 b6 13.Qe2
  Nf6 14.Bf2 Nh5 15.Bh4 Qc7 16.Ne1 f5 17.exf5 Rxf5 18.g3 Bb7
  19.Bc4 Bd4+ 20.Kh1 Qf7 21.Ng2 Re8 22.Qf3 Nxd5 23.g4 Rxf4
  24.Qxd5 Bxd5 25.Bxd5 Re6 26.Nxf4 Nxf4 27.Rxf4 Qxf4 28.Bxe6+
  Kg7 29.Bd5 Qxg4 30.Bg3 Qh5 31.Bg2 Be5 32.Bxe5+ Qxe5 33.h3 h5
  34.Rd1 g5 35.Rd5 Qe3 36.Ne4 g4 37.hxg4 hxg4 38.Nxd6 Qc1+
  39.Kh2 Qf4+ 40.Kh1 g3 41.Rd1 Qh6+ 42.Kg1 Qe3+ 43.Kh1 Qe2
  44.Nf5+ Kf6 45.Rf1 Qh5+ 46.Nh4 Ke7 47.Rf4 Qh8 48.Bf1 Qxb2
  49.Nf5+ Ke6 50.Nxg3 Qc1 1/2-1/2

  1.e4 c5 2.Nf3 e6 3.d4 cxd4 4.Nxd4 a6 5.c4 Nf6 6.Nc3 Bb4 7.Bd3
  Nc6 8.Ne2 Qc7 9.O-O Ng4 10.Bf4 Bd6 11.Bxd6 Qxd6 12.Ng3 h5
  13.h3 Nge5 14.Be2 Qxd1 15.Rfxd1 h4 16.Nf1 b6 17.Ne3 g5 18.Rd2
  Ke7 19.Rad1 Rd8 20.Rd6 Rb8 21.a3 a5 22.Nb5 Ba6 23.b3 Ng6
  24.Nc7 Bb7 25.f3 Nge5 26.Kf2 f6 27.Nb5 Nf7 28.R6d2 Nce5 29.Nc2
  Rbc8 30.Nc3 Rb8 31.Nd4 Rdc8 32.Ndb5 Ba6 33.Rd4 Rb7 34.Bf1 Nc6
  35.R4d2 Na7 36.Nd4 Ne5 37.Be2 Rcc7 38.Bf1 Nec6 39.c5 Bxf1
  40.cxb6 Rxb6 41.Na4 Rb5 42.Kxf1 Nxd4 43.Rxd4 Nc6 44.Rd6 Ne5
  45.Rb6 Rxb6 46.Nxb6 Rb7 47.Nc4 Rxb3 48.Nxe5 fxe5 49.Ra1 d5
  50.exd5 exd5 51.Rc1 Rxa3 52.Rc7+ Kd6 53.Rg7 Ra1+ 54.Kf2 Ra2+
  55.Kf1 a4 56.Rxg5 a3 0-1

  1.e4 g6 2.d4 Bg7 3.Nc3 d6 4.Nf3 c6 5.Bg5 Qb6 6.Qd2 Qxb2 7.Rb1
  Qa3 8.Bc4 Qa5 9.O-O e6 10.Rfe1 a6 11.Bf4 e5 12.dxe5 dxe5
  13.Qd6 Qxc3 14.Red1 Nd7 15.Bxf7+ Kxf7 16.Ng5+ Ke8 17.Qe6+ 1-0

  1.e4 c5 2.Nf3 Nc6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 e6 6.Ndb5 Bb4
  7.a3 Bxc3+ 8.Nxc3 d5 9.exd5 Nxd5 10.Bd2 O-O 11.Qh5 Nxc3
  12.Bxc3 e5 13.Bd3 g6 14.Qh6 Qf6 15.O-O Qg7 16.Qe3 g5 17.h4 h6
  18.hxg5 hxg5 19.f3 Be6 20.Kf2 Nd4 21.Rae1 Nc6 22.Rh1 f6 23.Rh7
  Qxh7 24.Bxh7+ Kxh7 25.Qd3+ Kg7 26.Rh1 Rh8 27.Rxh8 Rxh8 28.Qd6
  Re8 29.b4 a6 30.a4 Kf7 31.Qd3 Kg7 32.b5 Rd8 33.Qe4 Bd5 34.Qg4
  axb5 35.axb5 Ne7 36.Bb4 Ng6 37.Ba5 Ra8 38.Qd7+ Bf7 39.Bd8 Nf4
  40.Kg1 Ra2 41.Qf5 Nd5 42.c4 Ra8 43.Qd7 Nf4 44.Qe7 Ra1+ 45.Kh2
  Ra2 46.Qxf6+ Kg8 47.Qxg5+ Bg6 48.Qxe5 Rxg2+ 49.Kh1 Rd2 50.Qxf4
  Rxd8 51.Qc7 1-0

  1.Nf3 Nf6 2.c4 g6 3.d4 Bg7 4.Nc3 O-O 5.e4 d6 6.Be2 e5 7.O-O
  Nc6 8.dxe5 dxe5 9.Qxd8 Nxd8 10.Be3 Ne6 11.Rad1 Nf4 12.Rfe1
  Nxe2+ 13.Rxe2 b6 14.Bg5 Ba6 15.b3 Rfe8 16.Red2 Bb7 17.Bxf6
  Bxf6 18.Rd7 Rac8 19.Nb5 Bc6 20.Rxc7 Bxb5 21.Rxc8 Rxc8 22.cxb5
  Rc2 23.a4 Rb2 24.h3 Rxb3 25.Rd7 Rb4 26.Rxa7 Rxe4 27.Ra6 Kg7
  28.g4 h6 29.Rxb6 Rxa4 30.Rb8 Ra1+ 31.Kg2 e4 32.Ng1 Ra2 33.Kf1
  Ra1+ 34.Kg2 Bh4 35.Ne2 Ra2 36.Kf1 Ra1+ 37.Kg2 Re1 38.Ng3 e3
  39.fxe3 Rxe3 40.Nf1 Re2+ 41.Kh1 Rf2 42.Kg1 Rb2 43.Rc8 Bf2+
  44.Kh1 Bd4 45.Rd8 Be5 46.Nd2 Rxb5 47.Nf3 Bf4 48.Rd4 Rb1+
  49.Kg2 Rb2+ 50.Kh1 Be3 51.Rd3 Bc5 52.Rd2 Rb1+ 53.Kg2 Kf6
  54.Rc2 Bd6 55.Ra2 Rb6 56.Re2 Ra6 57.Nd2 Bf4 58.Rf2 Ra4 59.Re2
  Ra3 60.Nf3 Be3 61.Ne1 Rb3 62.Nf3 Rc3 63.Nd2 Bxd2 64.Rxd2 Kg5
  65.Rf2 Kh4 66.Rxf7 Rxh3 0-1

  1.e4 e5 2.Nf3 Nc6 3.Bb5 a6 4.Ba4 Nf6 5.O-O Be7 6.Re1 d6 7.c3
  O-O 8.d4 exd4 9.cxd4 Bg4 10.Nc3 Nd7 11.Be3 Nb6 12.Bb3 Bf6
  13.Qd3 Bxf3 14.gxf3 Qd7 15.Kg2 Ne7 16.Rg1 g6 17.Kh1 d5 18.Bg5
  Bxg5 19.Rxg5 c6 20.Ne2 Rad8 21.Rd1 Na8 22.Qe3 Nc7 23.Rdg1 Kh8
  24.R5g3 Ng8 25.Bc2 Ne6 26.Rd1 Qe7 27.a3 Rd7 28.b4 Nf6 29.Rh3
  Ng8 30.Rg1 dxe4 31.fxe4 Rfd8 32.Rd1 Kg7 33.f4 Nc7 34.f5 f6
  35.fxg6 hxg6 36.Rg1 Ne6 37.e5 Nf8 38.Bxg6 Nxg6 39.Nf4 Qf7
  40.e6 Re7 41.exf7 Rxe3 42.fxg8=Q+ 1-0

  1.d4 Nf6 2.c4 c5 3.d5 e6 4.Nc3 exd5 5.cxd5 d6 6.e4 g6 7.f3 Bg7
  8.Bg5 O-O 9.Qd2 Re8 10.Nge2 Nbd7 11.Nc1 a6 12.a4 Rb8 13.Be2
  Qc7 14.Nb3 Qb6 15.Ra3 Ne5 16.a5 Qb4 17.Na4 Nxd5 18.exd5 h6
  19.Nbxc5 dxc5 20.Bf4 Bd7 21.Nb6 Bf5 22.Kd1 Rbd8 23.Qxb4 cxb4
  24.Rb3 Nc6 25.Bc4 Nxa5 26.Rxb4 Nxc4 27.Rxc4 Bd3 28.Rb4 Bf8
  29.Rb3 Bb5 30.Bc7 Bc5 31.Rc3 Bd4 32.Kc1 Bxb6 33.Bxb6 Rxd5
  34.Rd1 Rde5 35.b3 Bc6 36.Bf2 Rb5 37.g3 Ra5 38.Rd2 Ra1+ 39.Kb2
  Rh1 40.Bb6 Rf1 41.Bf2 g5 42.f4 Kh7 43.Rc1 Rxc1 44.Kxc1 gxf4
  45.gxf4 Kg6 46.Rd6+ Re6 47.Rxe6+ fxe6 48.Bd4 Kf5 49.Be5 Kg4
  50.Kd2 Be4 51.Ke3 Bf5 52.Bf6 Kh3 53.Bg7 h5 54.b4 Kxh2 55.Kf2
  h4 56.Bd4 Kh3 57.Kf3 Bg4+ 58.Kf2 Bf5 59.Kf3 Bc2 60.Bb6 Bd1+
  61.Kf2 Kg4 62.Bc7 Bc2 0-1

  1.e4 c5 2.Nf3 Nc6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 d6 6.Bg5 e6 7.Qd2
  Be7 8.O-O-O O-O 9.Nb3 Qb6 10.f3 a6 11.g4 Rd8 12.Be3 Qc7 13.g5
  Nd7 14.h4 b5 15.g6 fxg6 16.h5 gxh5 17.Rxh5 Nf6 18.Rg5 Ne5
  19.Qg2 Bf8 20.Be2 Nc4 21.Bxc4 bxc4 22.Nd4 Rb8 23.Rh1 Rb7
  24.Rh6 Kf7 25.Rh4 Qb6 26.Nd1 Qc7 27.f4 h6 28.Rg6 Re8 29.f5 e5
  30.Nc3 Qd8 31.Nc6 1-0

  1.e4 e5 2.Nf3 Nc6 3.Bb5 a6 4.Ba4 Nf6 5.O-O Be7 6.Re1 d6
  7.Bxc6+ bxc6 8.d4 exd4 9.Qxd4 O-O 10.Nc3 c5 11.Qd3 Bb7 12.Bf4
  Nh5 13.Be3 Bf6 14.Nd5 Bxb2 15.Rab1 Bxd5 16.exd5 Rb8 17.c3 Qf6
  18.Qe2 Bxc3 19.Rxb8 Rxb8 20.Bg5 Bxe1 21.Bxf6 Nxf6 22.Qxe1 Nxd5
  23.g3 h6 24.Qe4 Nf6 25.Qc6 Rb1+ 26.Kg2 Rb2 27.Qxc7 Rxa2
  28.Qb8+ 1-0

  1.e4 c5 2.Nf3 d6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 e6 6.Bc4 Be7 7.Bb3
  O-O 8.f4 Na6 9.Qf3 Nc5 10.Be3 d5 11.exd5 exd5 12.O-O Re8 13.h3
  Nce4 14.Nxe4 dxe4 15.Qe2 Nd5 16.Rad1 Nxe3 17.Qxe3 Bc5 18.f5
  Qf6 19.Kh1 Bd7 20.Qc3 Bd6 21.Ne6 Be5 22.Qe3 Re7 23.Nc5 Qb6
  24.Qg5 Bf6 25.Nxd7 Rxd7 26.Qf4 Re7 27.Rfe1 e3 28.c3 h5 29.Re2
  Rae8 30.Qd6 Qb5 31.Qd3 Qe5 32.Rf1 a6 33.Rf3 b5 34.g3 Qc5 35.a4
  Qb6 36.Qc2 Qb7 37.Kg2 Rd8 38.axb5 axb5 39.Qc1 Bg5 40.h4 Rd2
  41.Qf1 Rxe2+ 0-1

  1.e4 e5 2.Nf3 Nc6 3.Bb5 a6 4.Ba4 Nf6 5.O-O Be7 6.Re1 b5 7.Bb3
  d6 8.c3 O-O 9.h3 h6 10.d4 Re8 11.Nbd2 Bf8 12.Nf1 Bd7 13.Ng3
  Na5 14.Bc2 c5 15.b3 g6 16.Be3 Nc6 17.d5 Ne7 18.Qd2 Kh7 19.Bxc5
  dxc5 20.Nxe5 Nc8 21.f4 Qe7 22.c4 Bg7 23.Nf3 bxc4 24.bxc4 Nd6
  25.e5 Nxc4 26.Qc3 Bb5 27.Rad1 Rad8 28.d6 Nxd6 29.exd6 Qb7
  30.Ne5 Nd7 31.Nh5 Bh8 32.Qg3 Nxe5 33.fxe5 Qd7 34.Nf4 Bxe5
  35.Bxg6+ Kh8 36.Bxf7 Bd4+ 37.Rxd4 Rxe1+ 38.Qxe1 Qxf7 39.Qe5+
  Qg7 40.Qxc5 Bc6 41.Rd2 1-0

  1.e4 d6 2.d4 g6 3.Nc3 Bg7 4.Nf3 c6 5.Bc4 Nf6 6.e5 dxe5 7.Nxe5
  O-O 8.O-O Nbd7 9.f4 Qc7 10.Qf3 a6 11.Re1 e6 12.Bb3 c5 13.Be3
  cxd4 14.Bxd4 Nxe5 15.fxe5 Nd7 16.Ne4 Bxe5 17.Bxe5 Qxe5 18.Rad1
  Kg7 19.Nd6 Qc5+ 20.Kh1 Ne5 21.Qf4 f6 22.Rf1 a5 23.h4 Ra6
  24.Ne4 Qe7 25.h5 h6 26.Qg3 a4 27.Rxf6 Rxf6 28.Qxe5 axb3
  29.axb3 b6 30.b4 1-0

  1.e4 e5 2.Nf3 Nc6 3.Bb5 a6 4.Ba4 d6 5.c3 Bd7 6.d4 Nge7 7.Bb3
  h6 8.Nh4 g5 9.Qh5 Rh7 10.Bxg5 exd4 11.f4 Qc8 12.f5 dxc3
  13.Nxc3 Ne5 14.Bf6 Ng8 15.Bxe5 dxe5 16.Ng6 Bd6 17.Bxf7+ Kxf7
  18.Nd5 Kg7 19.O-O Nf6 20.Nxf6 Kxf6 21.Nxe5 Qe8 22.Nxd7+ Rxd7
  23.e5+ Bxe5 24.Qxh6+ Kf7 25.Rae1 Rd5 26.Qh7+ Kf6 27.Re4 Bd4+
  28.Kh1 1-0

  1.e4 e6 2.d4 d5 3.Nc3 Bb4 4.e5 b6 5.Qg4 Bf8 6.Bg5 Qd7 7.Nf3
  Nc6 8.a3 Bb7 9.Bd3 h6 10.Bd2 O-O-O 11.h4 Nge7 12.O-O-O f5
  13.exf6 gxf6 14.Rde1 Rg8 15.Qxe6 Rxg2 16.Qe3 Kb8 17.Bf1 Rg8
  18.Bh3 f5 19.Qd3 Bc8 20.h5 Qe8 21.Bf4 Qxh5 22.Nb5 Rd7 23.Qc3
  Bb7 24.Ne5 Nxe5 25.dxe5 d4 26.e6 dxc3 27.exd7 Bg7 28.Nxc7 1-0

  1.e4 c5 2.Nf3 d6 3.d4 cxd4 4.Nxd4 Nf6 5.Nc3 a6 6.Bg5 e6 7.f4
  Be7 8.Qf3 Qc7 9.O-O-O Nbd7 10.g4 b5 11.Bxf6 Nxf6 12.g5 Nd7
  13.a3 Bb7 14.Bh3 O-O-O 15.Bxe6 fxe6 16.Nxe6 Qc4 17.Nd5 Bxd5
  18.exd5 Kb7 19.b3 Qc8 20.Rd3 Nb6 21.Rc3 Qd7 22.Rc7+ Qxc7
  23.Nxc7 Kxc7 24.Qc3+ Kb8 25.Qxg7 Nc8 26.Re1 Rdg8 27.Qd4 Bd8
  28.Re6 Rf8 29.h4 h6 30.g6 Rhg8 31.h5 Rf5 32.Qe4 Rxh5 33.Re8
  Rxe8 34.Qxe8 Bf6 35.c4 bxc4 36.bxc4 Rh3 37.Kd2 Bc3+ 38.Kc2 Bd4
  39.f5 Rxa3 40.c5 dxc5 41.d6 Ra2+ 42.Kd3 Ra3+ 43.Kc4 1-0

  1.e4 e5 2.Nf3 Nc6 3.Bb5 a6 4.Ba4 Nf6 5.O-O Be7 6.Re1 b5 7.Bb3
  d6 8.c3 O-O 9.h3 Na5 10.Bc2 c5 11.d4 Qc7 12.Nbd2 Bd7 13.Nf1
  Rfe8 14.b3 cxd4 15.cxd4 Nc6 16.Bb2 Nxd4 17.Nxd4 exd4 18.Rc1
  Qd8 19.Qxd4 Bf8 20.Rcd1 Rc8 21.Bb1 Bc6 22.Ng3 d5 23.Qe3 Nd7
  24.Nf5 f6 25.Qg3 Qc7 26.Qg4 Ne5 27.Bxe5 Rxe5 28.Nh6+ Kh8
  29.Nf7+ Qxf7 30.Qxc8 Bb7 31.Qc3 b4 32.Qc1 dxe4 33.Rd8 g5
  34.Qd2 Bc6 35.Qd6 Be8 36.Qb8 Kg7 37.Rxe4 Rb5 38.Qa8 Bd7 39.Bd3
  Rd5 40.Rxf8 1-0

  1.d4 Nf6 2.c4 g6 3.Nc3 Bg7 4.e4 O-O 5.f4 d6 6.Nf3 c5 7.d5 e6
  8.Be2 exd5 9.exd5 b5 10.Nxb5 Ne4 11.O-O a6 12.Na3 Ra7 13.Bd3
  Re7 14.Nc2 Rfe8 15.Re1 Nd7 16.Ne3 Ndf6 17.Qc2 Nh5 18.g3 Bd4
  19.Nxd4 cxd4 20.Ng2 Ng5 21.Rxe7 Nh3+ 22.Kf1 Rxe7 23.Bd2 Nf6
  24.Nh4 Ng4 25.Nf3 Re3 26.Kg2 Qe7 27.Re1 Nxf4+ 28.gxf4 Rxe1
  29.Nxe1 Qh4 30.Bc1 Qxe1 31.h3 Nh6 32.f5 Nxf5 33.Bf4 Nh4+
  34.Kh2 Nf3+ 35.Kg2 Bxh3+ 36.Kxf3 Qg1 37.Bxg6 Qg4+ 38.Kf2 Qxf4+
  39.Kg1 hxg6 0-1

  1.c4 Nf6 2.g3 c6 3.Nf3 d5 4.b3 Bf5 5.Bg2 e6 6.O-O Be7 7.Bb2
  O-O 8.d3 h6 9.Nbd2 a5 10.a3 Nbd7 11.Bc3 c5 12.Re1 d4 13.Bb2
  Qc7 14.h3 e5 15.e4 Be6 16.Nh4 g6 17.Bc1 Nh7 18.Ndf3 Ng5 19.Nh2
  Nxh3+ 20.Bxh3 Bxh3 21.Bxh6 Bxh4 22.gxh4 Qd8 23.Bg5 f6 24.Bd2
  Kf7 25.Qf3 Be6 26.Qg3 Rh8 27.f4 exf4 28.Bxf4 g5 29.hxg5 Rh3
  30.Qg2 Qh8 31.Rf1 Rxd3 32.e5 Qh3 33.g6+ Kg8 34.Qxb7 Rb8 35.Qc6
  fxe5 36.Rae1 Rdxb3 37.Rf3 Rxf3 38.Qxf3 exf4 39.Qe4 Re8 0-1

  1.e4 c5 2.Nf3 e6 3.Nc3 a6 4.Be2 b5 5.d4 cxd4 6.Nxd4 Bb7 7.a3
  Qc7 8.O-O Nf6 9.Qd3 d6 10.Bg5 Nbd7 11.Qe3 Be7 12.Rad1 O-O
  13.f4 Rac8 14.g4 Nb6 15.Bxf6 Bxf6 16.g5 Bxd4 17.Rxd4 e5 18.Rd2
  exf4 19.Rxf4 Rfe8 20.Qf2 Qe7 21.h4 Nc4 22.Bxc4 Rxc4 23.Rd4
  Rec8 24.Rxc4 Rxc4 25.Qa7 Qd7 26.Kf2 d5 27.Nxd5 Rxc2+ 28.Kg3
  Rc8 29.Rf6 Ra8 30.Qc5 Rd8 31.Rb6 Bxd5 32.exd5 Qf5 33.Qd6 Qd3+
  34.Kg2 Qc2+ 35.Kg3 Qb3+ 36.Kf4 Re8 37.Rb8 Qe3+ 38.Kg4 f5
  39.gxf6 h5 40.Kxh5 Qf3+ 41.Kg5 Qxf6+ 42.Qxf6 gxf6 43.Kxf6 Rxb8
  44.d6 Kf8 45.h5 Rb7 46.Ke6 Rh7 47.Kd5 Ke8 48.Kc6 Kd8 0-1

  1.e4 e5 2.Nf3 d5 3.exd5 e4 4.Qe2 f5 5.d3 Nf6 6.dxe4 fxe4 7.Nc3
  Bb4 8.Qb5+ c6 9.Qxb4 exf3 10.Bg5 cxd5 11.O-O-O Nc6 12.Qa3 Be6
  13.Bc4 Qe7 14.Nxd5 Qxa3 15.Nc7+ Ke7 16.Rhe1 Qc5 17.Rxe6+ Kf8
  18.Rxf6+ gxf6 19.Ne6+ Ke7 20.Nxc5 fxg5 21.Rd7+ Kf6 22.Rd6+ Ke7
  23.Re6+ Kd8 24.Nxb7+ Kc7 25.Bd5 Nb4 26.Bxf3 Rae8 27.Nc5 Nxa2+
  28.Kb1 Rxe6 29.Nxe6+ Kd7 30.Nc5+ Kd6 31.Nd3 1-0

  1. c4 g6 2. Nc3 Bg7 3. g3 c5 4. Bg2 Nc6 5. b3 e6 6. Bb2 Nge7
  7. Na4 Bxb2 8. Nxb2 O-O 9. e3 d5 10. Nf3 Nf5 11. O-O b6
  12. Na4 Bb7 13. cxd5 exd5 14. d3 Qf6 15. Qd2 Rad8 16. Rfd1
  Rfe8 17. Rab1 Nd6 18. Ne1 d4 19. e4 Qe7 20. Nc2 f5 21. exf5
  Ne5 22. f4 Nf3+ 23. Bxf3 Bxf3 24. Re1 Qe2 25. Rxe2 Rxe2
  26. Qxe2 Bxe2 27. Nb2 gxf5 28. Re1 Bh5 29. Nc4 Nxc4 30. bxc4
  Re8 31. Kf2 Rxe1 32. Kxe1 Kf8 33. Kd2 Ke7 34. Ne1 a6 35. a4 a5
  36. Kc2 Be8 37. Kb3 Bc6 38. Ka3 Kf6 39. Kb3 Kg6 40. Ka3 Kh5
  41. h3 Kg6 42. Kb3 Kg7 43. Ka3 Kf6 44. Kb3 Be8 45. Ng2 Bh5
  46. Kc2 Be2 47. Ne1 Bf1 48. Nf3 Bxh3 49. Ng5 Bg2 50. Nxh7+ Kg7
  51. Ng5 Kg6 52. Kd2 Bc6 53. Kc1 Bg2 54. Kd2 Kh5 55. Ne6 Kg4
  56. Nc7 Bc6 57. Nd5 Kxg3 58. Ne7 Bd7 59. Nd5 Bxa4 60. Nxb6 Be8
  61. Nd5 Kf3 62. Nc7 Bc6 63. Ne6 a4 64. Nxc5 a3 65. Nb3 a2
  66. Kc1 Kxf4 67. Kb2 Ke3 68. Na5 Be8 69. c5 f4 70. c6 Bxc6
  71. Nxc6 f3 72. Ne5 f2 0-1

  1.d4 d5 2.c4 c6 3.Nc3 Nf6 4.e3 Bf5 5.cxd5 cxd5 6.Qb3 Qb6
  7.Nxd5 Nxd5 8.Qxd5 Qb4+ 9.Bd2 Qxb2 10.Rc1 Bd7 11.Nf3 e6 12.Qc4
  Nc6 13.Be2 Bb4 14.Bxb4 Qxb4+ 15.Qxb4 Nxb4 16.Rc7 Bc6 17.Ne5
  O-O 18.Nxc6 bxc6 19.a3 Nd5 20.Rxc6 Rfc8 21.Rxc8+ Rxc8 22.Kd2
  g6 23.Bf3 Nb6 24.Rc1 Rxc1 25.Kxc1 Kf8 26.Kc2 Ke7 27.Kc3 a5
  28.h4 h6 29.e4 f6 30.e5 Kf7 31.Bc6 Ke7 32.f4 Kf7 33.g3 Ke7
  34.g4 g5 35.exf6+ Kxf6 36.fxg5+ hxg5 37.h5 Kg7 38.d5 exd5
  39.Kd4 Nc4 40.Bb5 Nd6 41.Bd3 Ne8 42.Bf5 Nf6 43.Ke5 1-0

  1.e4 c6 2.Nc3 d5 3.d4 dxe4 4.Nxe4 Nd7 5.Nf3 Ngf6 6.Ng3 e6
  7.Bd3 c5 8.O-O cxd4 9.Nxd4 Bc5 10.Nf3 O-O 11.Qe2 b6 12.Bf4 Bb7
  13.Rad1 Nd5 14.Bg5 Qc7 15.Nh5 Kh8 16.Be4 f6 17.Bh4 Bd6 18.c4
  Ba6 19.Nxg7 Kxg7 20.Nd4 Nc5 21.Qg4+ Kh8 22.Nxe6 Nxe6 23.Qxe6
  Rae8 24.Qxd5 Bxh2+ 25.Kh1 Qf4 26.Qh5 Qxe4 27.Rfe1 Qg6 28.Qxg6
  hxg6 29.Bxf6+ Kg8 30.Rxe8 Rxe8 31.Kxh2 Bxc4 32.Rd7 Re6 33.Bc3
  Bxa2 34.Rxa7 Bc4 35.Kg3 Bd5 36.f3 Kf8 37.Bd4 b5 38.Kf4 Bc4
  39.Kg5 Ke8 40.Ra8+ Kf7 41.Ra7+ Ke8 42.b4 Bd5 43.Ra3 Kf7 44.g4
  Re2 45.Bc5 Re5+ 46.Kh6 Re6 47.Rd3 Bc6 48.Rd8 Re8 49.Rd4 Re6
  50.f4 Ke8 51.Kg7 Be4 52.Bb6 Bf3 53.Rd8+ Ke7 54.Rd3 Be2 55.Bd8+
  Ke8 56.Rd2 Re3 57.Bg5 Bd3 58.f5 1-0

  1.d4 g6 2.c4 Bg7 3.g3 Nf6 4.Bg2 O-O 5.Nf3 d6 6.O-O c6 7.Nc3 a6
  8.e4 b5 9.e5 Ne8 10.cxb5 axb5 11.Bf4 b4 12.Ne4 Be6 13.Re1 Bd5
  14.b3 dxe5 15.dxe5 Na6 16.Qc1 Nec7 17.Nd4 c5 18.Nf3 Ne6 19.Rd1
  Ra7 20.Nfg5 Nd4 21.Qe3 Nc2 22.Qe2 Nxa1 23.Nxh7 Nc7 24.Nxf8
  Qxf8 25.Rxa1 Qa8 26.Qd3 Kf8 27.Rd1 g5 28.Bxg5 Rxa2 29.Nxc5
  Bxg2 30.Qh7 Bh3 31.Nd7+ 1-0
"""
    .trimIndent()
