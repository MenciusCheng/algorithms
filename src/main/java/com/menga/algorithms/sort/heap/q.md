## 2.4 优先队列

优先队列支持删除最大元素和插入元素。

### 2.4.1 API

```
public class MaxPQ<T extends Comparable<T>>

    MaxPQ()
    
    MaxPQ(int max)
    
    MaxPQ(T[] a)
    
    void insert(T t)
    
    T max()
    
    T delMax()
    
    boolean isEmpty()
    
    int size()
```

### 2.4.2 初级实现

数据结构    插入元素    删除最大元素
有序数组    N           1
无序数组    1           N
堆          logN        logN
理想情况    1           1

### 2.4.3 堆的定义

定义：当一颗二叉树的每个结点都大于等于它的两个子结点时，它被称为堆有序。

定义：二叉堆是一组能够用堆有序的完全二叉树排序的元素，并在数组中按照层级储存（不使用数组的第一个位置）。

（简单起见，在下文中将二叉堆简称为堆）在一个堆中，位置 k 的结点的父结点的位置为 ⌊k/2⌋，而它的两个子结点的位置则分别为 2k 和 2k+1。

### 2.4.4 堆的算法

**由下至上的堆有序化（上浮）**

动图

```
private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
        swap(k / 2, k);
        k = k / 2;
    }
}
```

**由上至下的堆有序化（下沉）**

```
private void sink(int k) {
    while (2 * k <= N) {
        int j = 2 * k;
        if (j < N && less(j, j + 1))
            j++;
        if (!less(k, j))
            break;
        swap(k, j);
        k = j;
    }
}
```

**插入元素**。将新元素加到数组末尾，增加堆的大小并让这个新元素上浮到合适的位置。

**删除最大元素**。从数组顶端删去最大的元素并将数组的最后一个元素放到顶端，减少堆的大小并让这个元素下沉到合适的位置。


### 2.4.5 堆排序










