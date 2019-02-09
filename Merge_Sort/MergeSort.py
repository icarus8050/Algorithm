def merge_sort(data_list):

    def merge(left, right):
        result = []
        while len(left) > 0 and len(right) > 0:
            if left[0] <= right[0]:
                result.append(left[0])
                del left[0]
            else:
                result.append(right[0])
                del right[0]

        while len(left) > 0:
            result.append(left[0])
            del left[0]

        while len(right) > 0:
            result.append(right[0])
            del right[0]

        return result

    if len(data_list) <= 1:
        return data_list

    mid = len(data_list) // 2
    left_list = data_list[:mid]
    right_list = data_list[mid:]

    left_list = merge_sort(left_list)
    right_list = merge_sort(right_list)

    return merge(left_list, right_list)