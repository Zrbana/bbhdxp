package DataStructures.Heaps;

import DataStructs.Heaps.EmptyHeapException;
import DataStructs.Heaps.HeapElement;

/**
 *
 *用于堆数据结构的通用接口。<br>
 * 堆是树状的数据结构，允许在一个特定的存储元素
 *每个节点对应一个元素，并且有一个父节点(根节点除外)和
 *最多两个子节点。每个元素都包含一个键和那些键
 *说明如何建造树。例如，对于最小堆，节点的键应该
 *大于或等于其父结点，小于或等于子结点(与之相反的规则适用于a
 * max-heap)
 * 所有与堆相关的操作(插入或删除一个元素，提取最小或最大)都在
 * O(log n)时间
 *

 */
public interface Heap {

    /**
     * @return the top element in the heap, the one with lowest key for min-heap or with
     * the highest key for max-heap
     * @throws EmptyHeapException if heap is empty
     */
    HeapElement getElement() throws EmptyHeapException;

    /**
     * Inserts an element in the heap. Adds it to then end and toggle it until it finds its
     * right position.
     *
     * @param element an instance of the HeapElement class.
     */
    void insertElement(HeapElement element);

    /**
     * Delete an element in the heap.
     *
     * @param elementIndex int containing the position in the heap of the element to be deleted.
     */
    void deleteElement(int elementIndex);

}