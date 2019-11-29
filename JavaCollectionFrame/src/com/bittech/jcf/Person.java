package com.bittech.jcf;

/**
 * Author: secondriver
 * Created: 2019/4/7
 */
public class Person implements Comparable<Person> {
    
    private String name;
    
    private Integer age;
    
    public Person() {
    }
    
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person person = (Person) o;
//
//        if (!name.equals(person.name)) return false;
//        return age.equals(person.age);
//    }
//
//    @Override
//    public int hashCode() {
////        int result = name.hashCode();
////        result = 31 * result + age.hashCode();
////        return result;
//        return Objects.hash(name,age);
//    }
    
    @Override
    public int compareTo(Person o) {
        //this  compareTo o
        //this > o return > 0
        //this == 0 return 0
        //this < o  return <0
        //按照年龄排序
//        return this.age - o.age;
        return this.getName().compareTo(o.getName());
//        return Integer.compare(this.age,o.getAge());
    }
}
