package main;

import java.util.HashSet;
import java.util.Set;

public class PriorityQueue {

    private java.util.PriorityQueue<QueueEntry> data;
    private Set<Integer> containedIndices;
    private Set<Integer> blackList;

    /**
     * Creates an empty PriorityQueue.
     */
    public PriorityQueue() {
	data = new java.util.PriorityQueue<PriorityQueue.QueueEntry>();
	containedIndices = new HashSet<Integer>();
	blackList = new HashSet<Integer>();
    }

    /**
     * Creates a new entry in the priority queue and enqueues it at the correct
     * position.
     * 
     * @param idx      Index of the vertex.
     * @param distance Distance to the source node.
     */
    public void enqueue(int idx, double distance) {
	if (!blackList.contains(idx)) {
	    QueueEntry entry = new QueueEntry(idx, distance);
	    data.add(entry);
	    containedIndices.add(idx);
	}
    }

    /**
     * Checks if queue is empty
     * 
     * @return True if queue is empty, false otherwise.
     */
    public boolean isEmpty() {
	return data.isEmpty();
    }

    /**
     * Provides the vertex index of the vertex with the shortest distance value in
     * the queue.
     * 
     * @return The vertex index with the highest priority.
     */
    public int getNode() {
	QueueEntry entry = data.peek();
	return entry.getIdx();
    }

    /**
     * Provides the distance of the vertex that has the shortest distance value in
     * the queue.
     * 
     * @return The distance of the index with the highest priority.
     */
    public double getDistance() {
	QueueEntry entry = data.peek();
	return entry.getDistance();
    }

    /**
     * Removes the highest priority entry from the queue
     */
    public void pop() {
	QueueEntry entry = data.poll();
	containedIndices.remove(entry.getIdx());
    }

    /**
     * Checks if the Queue contains the vertex with the given index.
     * 
     * @param idx Index to look for in the queue.
     * @return True if index is found, false otherwise.
     */
    public boolean contains(int idx) {
	return containedIndices.contains(idx);
    }

    /**
     * Updates the distance value of the vertex with the given index.
     * 
     * @param idx      Index of vertex whose distance will be updated.
     * @param distance New distance.
     */
    public void update(int idx, double distance) {
	QueueEntry old = new QueueEntry(-1, -1);
	for (QueueEntry e : data) {
	    if (e.getIdx() == idx && e.getDistance() > distance) {
		old = e;
		break;
	    }
	}
	if (old.getIdx() != -1) {
	    data.remove(old);
	    QueueEntry entry = new QueueEntry(idx, distance);
	    data.add(entry);
	}
    }

    /**
     * Blocks a vertex from being added to the Queue again in the future.
     * 
     * @param idx Vertex that is going to be blocked.
     */
    public void blockInFuture(int idx) {
	blackList.add(idx);
    }

    /**
     * Method for printing the content of the Queue to the console.
     */
    public void print() {
	System.out.print("Queue: ");
	for (QueueEntry e : data) {
	    System.out.print("{" + e.getIdx() + "," + e.getDistance() + "} ");
	}
	System.out.println();
    }

    // A queue-entry, used internally.
    private class QueueEntry implements Comparable<QueueEntry> {
	private int idx;
	private double distance;

	public QueueEntry(int idx, double distance) {
	    this.idx = idx;
	    this.distance = distance;
	}

	public int getIdx() {
	    return idx;
	}

	public double getDistance() {
	    return distance;
	}

	@Override
	public int compareTo(QueueEntry other) {
	    if (distance < other.distance) {
		return -1;
	    } else if (distance == other.distance) {
		return 0;
	    } else {
		return 1;
	    }
	}
    }

}
