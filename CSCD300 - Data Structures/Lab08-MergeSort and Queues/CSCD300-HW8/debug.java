
public class debug {

	public static void main(String[] args) {
		
        LinkedList A = new LinkedList(); 
        LinkedList A2 = new LinkedList();

        int ramdomListSize = 20;
        
        for(int i = 0; i < ramdomListSize; i++) {
            int randomInt = (int)(Math.random() * 100);
            A.addLast(randomInt);
            A2.addLast(randomInt);
        }

		System.out.println("is LL sorted?: " + A.isSorted());
		System.out.println("LL before MergeSort: " + A);
		
		double then = System.currentTimeMillis();
		A.MergeSort();
        double now = System.currentTimeMillis();
        
        System.out.println("is LL sorted?: " + A.isSorted());
        System.out.println("LL after MergeSort: " + A);
        System.out.println("Time cost in milliseconds for mergesort " + (now - then));
				
        System.out.println("is LL sorted?: " + A2.isSorted());
		System.out.println("LL before InsertionSort: " + A2);
		
		then = System.currentTimeMillis();
        A2.InsertionSort();
        now = System.currentTimeMillis();
        
        System.out.println("is LL sorted?: " + A2.isSorted());
     	System.out.println("LL after InsertionSort: " + A2);
        System.out.println("Time cost in milliseconds for insertionsort " + (now - then));
	
		/*
		Queue b = new Queue();
		b.enqueue("A");
		b.enqueue("B");
		System.out.println(b);
		b.dequeue();
		System.out.println(b);
		System.out.println(b.front());
		System.out.println();
		*/
	
	}

}

