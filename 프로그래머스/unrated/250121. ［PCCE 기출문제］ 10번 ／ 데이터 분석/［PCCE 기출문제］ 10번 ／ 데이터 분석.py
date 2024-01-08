def solution(data, ext, val_ext, sort_by):
    answer = []
    cri = 0
    sortby = 0
    if ext == "code":
        cri = 0
    elif ext == "date":
        cri = 1
    elif ext == "maximum":
        cri = 2
    elif ext == "remain":
        cri = 3
        
    if sort_by == "code":
        sortby = 0
    elif sort_by == "date":
        sortby = 1
    elif sort_by == "maximum":
        sortby = 2
    elif sort_by == "remain":
        sortby = 3
    
    for i in data:
        if i[cri] < val_ext:
            answer.append(i)
    
    answer.sort(key=lambda x : x[sortby])
    return answer