def solution(players, callings):
  rank_map = {}

  for i, player in enumerate(players):
    rank_map[player] = i
  
  for calling in callings:
    rank_index = rank_map[calling]
    front_player = players[rank_index - 1]
    called_player = players[rank_index]
    
    players[rank_index] = front_player
    players[rank_index - 1] = called_player
    
    rank_map[front_player] = rank_index
    rank_map[called_player] = rank_index - 1
  return players
