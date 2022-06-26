import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main_Sort {
	
	public static float[] reverse(float[] arr){
		for (int i = 0; i < arr.length / 2; i++) {
			float temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
		
		return arr;
	}
	
	public static void show(float[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		Algorithm al = new Algorithm();
		float[] arr = new float[0];
		float[] arr2;
		
		
		//tiêu chi nâng cao 
		float[] arr3;
		// Created random array for advanced requirements.
		float[] arrRandom = new float[1000];
//		for (int i = 0; i < arrRandom.length; i++) {
//			arrRandom[i] = (float) (Math.floor(Math.random() * 1000 ));
//		}

		for (int i = 0; i < arrRandom.length; i++) {
			arrRandom[i] = i + 1;
		}
		
	
	

		int choice = 0;
		do {
			System.out.println("+-------------------Menu------------------+");
			System.out.println("|      1.Input                            |");
			System.out.println("|      2.Output                           |");
			System.out.println("|      3.Bubble sort                      |");
			System.out.println("|      4.Selection sort                   |");
			System.out.println("|      5.Insertion sort                   |");
			System.out.println("|      6.Search > value                   |");
			System.out.println("|      7.Search = value                   |");
			System.out.println("|      0.Exit                             |");
			System.out.println("+-------------------Menu------------------+");

			choice = sc.nextInt();
			System.out.println("Choice: " + choice);
			if (choice == 0) {
				System.out.println("Thanks!");
				System.out.println("Good bye, have a nice day!");
			}

			switch (choice) {

			// Nhập dữ liệu vào mảng , và lưu vào file INPUT.TXT
			case 1:

				System.out.println("Input number of elements: ");
				int n = sc.nextInt();
				System.out.println("Input elements: ");
				arr = new float[n];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = sc.nextFloat();

				}
			
				al.writeFile("INPUT.TXT", arr);
				break;

			// Đọc dũ liệu tư file INPUT.TXT lên chương trình
			case 2:
				System.out.println("Read from file");
				arr = al.readFile("INPUT.TXT");
				System.out.print("Array a: ");
				for (int i = 0; i < arr.length; i++) {

					System.out.print(arr[i] + " ");
				}
				System.out.println();
				break;

			// Thực hiện sắp xếp nổi bọt
			case 3:
				System.out.println("Bubble sort");
				arr2 = arr.clone();
				al.bubbleSort(arr2);
				break;

			// Thực hiện sắp xếp chọn
			case 4:

				System.out.println("Selection sort");
				arr2 = arr.clone();
				al.selectionSort(arr2);
				break;

			// Thực hiện sắp xếp chèn
			case 5:
				System.out.println("Insertion sort");
				arr2 = arr.clone();
				al.insertionSort(arr);
				break;

			// Thực hiện tìm kiếm tuyến tính
			case 6:
				System.out.print("Input value: ");
				arr2 = al.readFile("INPUT.TXT");
				float value = sc.nextFloat();

				System.out.println("Linear Search");
				System.out.print("Index of values > input:");
				al.search(arr2, value);

				break;

			// Thực hiện tìm kiếm nhị phân
			case 7:
				arr2 = arr.clone();
				al.sort(arr2);
				System.out.print("Input value: ");
				float value2 = sc.nextFloat();
				System.out.println("Linear Search");
				System.out.println("Index of fist element:" + al.binarySearch(arr2, 0, arr2.length - 1, value2));

				break;
				
		// Kiem tra thoi gian chay cua mảng
			case 8: 
				// du lieu da duoc sap xep
//				arr3 = arrRandom;
//				al.writeFile("INPUT.TXT", arr3);

				//du lieu da duoc sap xep nguoc lai
				arr3 = arrRandom;
				reverse(arr3);
				al.writeFile("INPUT.TXT", arr3);
			
				
				//du lieu co xao tron ngau nhien
//				arr3 = arrRandom;
//				al.writeFile("INPUT.TXT", arr3);
				
				
				break;

			default:
				break;
			}
		} while (choice != 0);

	}
}
