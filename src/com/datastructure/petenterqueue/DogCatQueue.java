package com.datastructure.petenterqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  * 实例DogCatQueue
 *  *
 *  * @version 1.0
 *  
 */
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList <PetEnterQueue>();
        this.catQ = new LinkedList <PetEnterQueue>();
        this.count = 0;
    }

    public boolean isEmpty() {
        return isCatEmpty() && isDogEmpty();
    }

    public boolean isCatEmpty() {
        return this.catQ.isEmpty();
    }

    public boolean isDogEmpty() {
        return this.dogQ.isEmpty();
    }

    public Cat pollCat() {
        if (!isCatEmpty()) {
            throw new RuntimeException("cat queue is empty!");
        }
        return (Cat) this.catQ.poll().getPet();
    }

    public Dog pollDog() {
        if (!isCatEmpty()) {
            throw new RuntimeException("dog queue is empty!");
        }
        return (Dog) this.dogQ.poll().getPet();
    }

    public Pet pollAll() {
        if (!isEmpty()) {
            if (this.dogQ.peek().getCount() > this.catQ.peek().getCount()) {
                return this.catQ.poll().getPet();
            } else {
                return this.dogQ.poll().getPet();
            }
        } else if (!isCatEmpty()) {
            return this.catQ.poll().getPet();
        } else if (!isDogEmpty()) {
            return this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("the queue is empty!");
        }
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getPetType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("err, not dog and cat!");
        }
    }

}
