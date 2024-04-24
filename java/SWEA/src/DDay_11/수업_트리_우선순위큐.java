package DDay_11;

import java.util.Comparator;
import java.util.PriorityQueue;

class Person implements Comparable<Person> {
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		if (this.age == o.age) {
			return this.name.compareTo(o.name);
		}
		return this.age - o.age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class 수업_트리_우선순위큐 {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});

		// 우선순위 큐 : 기본 정렬 순서는 오름차순
		// 내림차순 바꾸고 싶으면 음수를 쓰자

//		pq.add(12);
//		pq.add(23);
//		pq.add(5532);
//		pq.add(558);
//		pq.offer(73);
//
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());
//		System.out.println(pq.poll());

		PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> {
			return b - a;
		});
		
//		pq2.add(12);
//		pq2.add(23);
//		pq2.add(5532);
//		pq2.add(558);
//		pq2.offer(73);
//
//		System.out.println(pq2.poll());
//		System.out.println(pq2.poll());
//		System.out.println(pq2.poll());
//		System.out.println(pq2.poll());
//		System.out.println(pq2.poll());
		
		// Person은 비교기준이 없기때문에 예외 발생
		// 기준을 만들어주기 위해서
		// 1. Comparator를 PQ 생성자에 넣어준다(람다식)
		// 2. Person이 Comparable 인터페이스를 구현
		PriorityQueue<Person> pq3 = new PriorityQueue<>();
		
		pq3.add(new Person("김준철", 20));
		pq3.add(new Person("김영원", 20));
		pq3.add(new Person("양명균", 20));
		pq3.add(new Person("이승재", 20));
		pq3.add(new Person("오지혜", 20));
		
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());
		System.out.println(pq3.poll());

	}

}
