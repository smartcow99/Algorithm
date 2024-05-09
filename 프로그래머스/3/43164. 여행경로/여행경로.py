def solution(tickets):
    answer = []
    
    graph = {}
    
    for s, e in tickets:
        if s not in graph:
            graph[s] = []
        graph[s].append(e)
    
    for k in graph.keys():
        graph[k].sort(reverse=True)
    
    stk = ["ICN"]
    path = []
    
    while stk:
        top = stk[-1]
        
        if top not in graph or len(graph[top]) == 0:
            path.append(stk.pop())
        else:
            stk.append(graph[top].pop())
    
    answer = path[::-1]
    
    return answer