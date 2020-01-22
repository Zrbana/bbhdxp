package DataStructs.Heaps;

import java.lang.Double;
import java.lang.Object;

/**
 * 用于堆元素的类。<br>
 * <p>一个堆元素包含两个属性:一个键，将用于构建树(int
 *或双，无论是原始类型或对象)和任何类型的不可变的对象，用户认为合适
 携带任何他/她喜欢的信息。请注意，使用可变对象可能会
 *危害该信息的完整性。< / p >
 *
 */
public class HeapElement {
    private final double key;
    private final Object additionalInfo;

    // Constructors

    /**
     * @param key  : a number of primitive type 'double'
     * @param info : any kind of IMMUTABLE object. May be null, since the purpose is only to carry
     *             additional information of use for the user
     */
    public HeapElement(double key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    /**
     * @param key  : a number of primitive type 'int'
     * @param info : any kind of IMMUTABLE object. May be null, since the purpose is only to carry
     *             additional information of use for the user
     */
    public HeapElement(int key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    /**
     * @param key  : a number of object type 'Integer'
     * @param info : any kind of IMMUTABLE object. May be null, since the purpose is only to carry
     *             additional information of use for the user
     */
    public HeapElement(Integer key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    /**
     * @param key  : a number of object type 'Double'
     * @param info : any kind of IMMUTABLE object. May be null, since the purpose is only to carry
     *             additional information of use for the user
     */
    public HeapElement(Double key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    /**
     * @param key : a number of primitive type 'double'
     */
    public HeapElement(double key) {
        this.key = key;
        this.additionalInfo = null;
    }

    /**
     * @param key : a number of primitive type 'int'
     */
    public HeapElement(int key) {
        this.key = key;
        this.additionalInfo = null;
    }

    /**
     * @param key : a number of object type 'Integer'
     */
    public HeapElement(Integer key) {
        this.key = key;
        this.additionalInfo = null;
    }

    /**
     * @param key : a number of object type 'Double'
     */
    public HeapElement(Double key) {
        this.key = key;
        this.additionalInfo = null;
    }

    // Getters

    /**
     * @return the object containing the additional info provided by the user.
     */
    public Object getInfo() {
        return additionalInfo;
    }

    /**
     * @return the key value of the element
     */
    public double getKey() {
        return key;
    }

    // Overridden object methods

    public String toString() {
        return "Key: " + key + " - " + additionalInfo.toString();
    }

    /**
     * @param otherHeapElement
     * @return true if the keys on both elements are identical and the additional info objects
     * are identical.
     */
    public boolean equals(HeapElement otherHeapElement) {
        return (this.key == otherHeapElement.key) && (this.additionalInfo.equals(otherHeapElement.additionalInfo));
    }
}
