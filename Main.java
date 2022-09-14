import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws Exception {

        Node head1 = new Node();
        Node curr1 = head1;


        Node head2 = new Node();
        Node curr2 = head2;

        //import nums1
        Scanner file = new Scanner(new File("src/nums1.txt"));
        //import nums2
        Scanner file2 = new Scanner(new File("src/nums2.txt"));

        //finding size of the file
        int size1 = 0;
        while (file.hasNextInt()) {
            size1++;
            file.nextInt();
        }

        //finding size of the file
        int size2 = 0;
        while (file2.hasNextInt()) {
            size2++;
            file2.nextInt();
        }

        //reset the scanners
        file = new Scanner(new File("src/nums1.txt"));
        file2 = new Scanner(new File("src/nums2.txt"));
        //set the values of the nodes to the values of the
        for (int i = 0; i < size1; i++){
            curr1.value = file.nextInt();
            if(i < size1 - 1){
                curr1.next = new Node();
                curr1.next.prev = curr1;
                curr1 = curr1.next;
            }
        }
        for (int i = 0; i < size2; i++){
            curr2.value = file2.nextInt();
            if(i < size2 - 1){
                curr2.next = new Node();
                curr2.next.prev = curr2;
                curr2 = curr2.next;
            }
        }

        //moving the currs to the ends
        while (curr1.next != null){
            curr1 = curr1.next;
        }
        while (curr2.next != null){
            curr2 = curr2.next;
        }

        //adding
        Node head3 = new Node();
        Node curr3 = head3;
        int carry = 0;
        int c1;
        int c2;

        while (curr1 != null || curr2 != null){
            if (curr1 != null){
                c1 = curr1.value;
            }else{
                c1 = 0;
            }
            if (curr2 != null){
                c2 = curr2.value;
            }else{
                c2 = 0;
            }
            if (c1 + c2 + carry < 10){
                System.out.println("no carrying curr3: " + curr3.value + " curr1.value: " + c1 + " curr2.value: " + c2);
                curr3.value = c1 + c2 + carry;
                carry = 0;
                System.out.println("curr3.value: " + curr3.value);
                System.out.println();
            }else {
                System.out.println("carrying curr3: " + curr3.value + " curr1.value: " + c1 + " curr2.value: " + c2 + " carry: " + carry);
                String digit1 = Integer.toString(c1 + c2 + carry).substring(0, 1);
                String digit2 = Integer.toString(c1 + c2 + carry).substring(1, 2);
                System.out.println("carrying digit1: " + digit1 + " digit2: " + digit2);
                curr3.value = Integer.valueOf(digit2);
                carry = Integer.valueOf(digit1);
                System.out.println("carrying curr3: " + curr3.value + " curr1.value: " + c1 + " curr2.value: " + c2 + " carry: " + carry);
                System.out.println();
            }

            System.out.println("at end of while loop print curr3.value: " + curr3.value);
            System.out.println();
            if (curr1 != null){
                curr1 = curr1.prev;
            }
            if (curr2 != null){
                curr2 = curr2.prev;
            }
            curr3.prev = new Node();
            curr3.prev.next = curr3;
            curr3 = curr3.prev;

        }
        System.out.println("adding extra carry:" + carry);
        //curr3.value = carry;
        curr3 = curr3.next;

        while (curr3 != null){
            System.out.print(curr3.value);
            curr3 = curr3.next;
        }
        /*
        //reset curr
        curr1 = head1;
        //print out the values in the linked list
        while (curr1 != null) {
            System.out.println(curr1.value);
            curr1 = curr1.next;
        }
        */
    }
}
