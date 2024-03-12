package com.neetcode.beginners.algods.o13heappq;


// leftChild = heap[2 * i]
// rightChild = heap[(2 * i) + 1]
// parent = heap[i // 2]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap {
    List<Integer> heap;

    public Heap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        // percolate up
        while(i > 1 && heap.get(i) < heap.get(i / 2)) {
            swap(heap, i, i / 2);
            i = i / 2;
        }
    }

    public int pop() {
        if (heap.size() == 1) return -1;

        // equivalent to heap.remove(1)
        if (heap.size() == 2) return heap.remove(heap.size() - 1);

        int result = heap.get(1);
        // Move the last element in the heap to the root and perform heapify down
        heap.set(1, heap.remove(heap.size() - 1));

        //percolate down
        // In a heap we have following conditions
        // 1. A node could have both left and right child
        // 2. Leaf node with no left and right child
        // 3.  Pen ultimate to the leaf node could have just one left child
        //     Note we will never have just right child because it will violate the structural integrity
        //     of the heap. Binary tree to be full (filled from left to right with no gaps)
        // That is why we are just checking while we have left child 2 * i
        int i = 1;
        // while we have a left child
        while(2 * i < heap.size()) {
            // Do we have a right child. Now that we have established we have left child(from while loop)
            // and right child lets check if right child is smaller than left and parent and swap it.
            if (2 * i + 1 < heap.size() &&
                    heap.get(2 * i + 1) < heap.get(2 * i) &&
                    heap.get(2 * i + 1) < heap.get(i)){
                swap(heap, 2 * i + 1, i);
                i = 2 * i + 1;
            } else if (heap.get(2 * i) < heap.get(i)) {
                swap(heap, 2 * i, i);
                i = 2 * i;
            } else {
                break;
            }
        }
        return result;
    }

    public void heapify(ArrayList<Integer> arr) {
        // 0-th position is moved to the end
        arr.add(arr.get(0));
        heap = arr;
        // Half of the elements are at leaf node, so we have to get to the possibly first parent
        // that is left most leaf element that could have child
        // root 1 (0) -> 2 (1,2) child -> 4 (3, 4,5, 6) child -> 8 (7, 8, 9, 10, 11, 12, 13, 14) child
        int cur = (heap.size() - 1) / 2;
        while(cur > 0) {
            int i = cur;
            // Percolate Down -> same code as above
            while (2 * i < heap.size()) {
                if (2 + i + 1 < heap.size() &&
                        heap.get(2 + i + 1) < heap.get(2 * i) &&
                        heap.get(i) > heap.get(2 * i + 1)) {
                    // Swap right child
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2 * i + 1));
                    heap.set(2 * i + 1, tmp);
                    i = 2 * i + 1;
                } else if (heap.get(i) > heap.get(2 * i)) {
                    // Swap left child
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2 * i));
                    heap.set(2 * i, tmp);
                    i = 2 * i;
                } else {
                    break;
                }
            }
            cur = cur - 1;
        }
        return;
    }

    public void swap(List<Integer> heap, int index1, int index2) {
        int tmp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, tmp);
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 5, 3, 10, 22, 2));
        heap.heapify(list);
//        heap.push(4);
//        heap.push(5);
//        heap.push(3);
//        heap.push(10);
//        heap.push(22);
//        heap.push(2);
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop()); // does not exist
    }
}
