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

        //new linked list for storing the sum
        Node head3 = new Node();
        Node curr3 = head3;
        //if a nummber needs to be carried over it will be stored in this value
        int carry = 0;
        //these are used to make sure that the program doesn't try to read a null value
        int c1;
        int c2;

        while (curr1 != null || curr2 != null){
            //makes sure that curr1 or curr2 is never null
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

            if (c1 + c2 + carry < 10){ //no carrying needed
                curr3.value = c1 + c2 + carry;
                carry = 0;
            }else { // the digits add up to > 10 so we have to carry to the next number
                //get first digit of the sum of the 2 numbers being added and store it in digit1 which will later go in carry
                String digit1 = Integer.toString(c1 + c2 + carry).substring(0, 1);
                //get the second digit which is the digit that will be
                String digit2 = Integer.toString(c1 + c2 + carry).substring(1, 2);
                curr3.value = Integer.valueOf(digit2);
                //set the number to be carried to digit 1
                carry = Integer.valueOf(digit1);
            }
            System.out.println();
            //move the currs to the next number to be added
            if (curr1 != null){
                curr1 = curr1.prev;
            }
            if (curr2 != null){
                curr2 = curr2.prev;
            }
            //make a new node for the linked list for the sum
            curr3.prev = new Node();
            curr3.prev.next = curr3;
            curr3 = curr3.prev;

        }

        //skip the first digit because its unused
        curr3 = curr3.next;
        //print out the sum in the correct order
        while (curr3 != null){
            System.out.print(curr3.value);
            curr3 = curr3.next;
        }

    }
}
