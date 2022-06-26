
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class Algorithm {

	// Hàm xuất dữ liệu
	public void display(float[] arr) {

		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	
	// hàm ghi dữ liệu vào file
	public void writeFile(String fileName, float arr[]) {

		try {
			PrintWriter pw = new PrintWriter(fileName);
			for (float a : arr) {
				pw.print(a + " ");

			}

			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block		
			e.printStackTrace();
		}

	}
	
	//hàm đọc dữ liệu

	public float[] readFile(String fileName) throws IOException {

		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line;
		float[] arr = null;
		while (true) {

			line = br.readLine();
			if (line == null) {
				break;
			}
		

			String[] string = line.split(" ");
			arr = new float[string.length];
			for (int i = 0; i < string.length; i++) {
				arr[i] = Float.parseFloat(string[i]);
			}

		}
		return arr;

	}
	
	// hàm sắp xếp nổi bọt

	public float[] bubbleSort(float a[]) throws FileNotFoundException {

		long begin = Calendar.getInstance().getTimeInMillis();

		float[] b = a;
		int n = b.length;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n - i - 1; j++) {
				if (b[j] > b[j + 1]) {

					float temp = b[j];
					b[j] = b[j + 1];
					b[j + 1] = temp;

				}
			}

			display(b);
		}

		long end = Calendar.getInstance().getTimeInMillis();
//		long secondsEnd = end / 1000;
		System.out.println("Executed Time: " + (end - begin) + "ms");

		File f = new File("OUTPUT1.TXT");
		PrintWriter pw1 = new PrintWriter(f);
		for (float g : b) {
			pw1.print(g + " ");
		}
		pw1.flush();
		pw1.close();
		return b;

	}
	
	// hàm sắp xêp chọn
	public float[] selectionSort(float a[]) throws FileNotFoundException {

		long begin = Calendar.getInstance().getTimeInMillis();
		float[] b = a;

		int min_index;
		for (int i = 0; i < b.length; i++) {
			min_index = i;
			for (int j = i + 1; j < b.length; j++) {
				if (b[j] < b[min_index]) {
					min_index = j;
				}

			}
			if (min_index != i) {
				float temp = b[min_index];
				b[min_index] = b[i];
				b[i] = temp;
			}
			display(b);

		}
		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Executed Time: " + (end - begin) + "ms");

		File f = new File("OUTPUT2.TXT");
		PrintWriter pw1 = new PrintWriter(f);
		for (float g : b) {
			pw1.print(g + " ");
		}
		pw1.flush();
		pw1.close();
		return b;
	}

	
	// hàm sắp xêp chèn
	public float[] insertionSort(float a[]) throws FileNotFoundException {
		long begin = Calendar.getInstance().getTimeInMillis();
		float[] b = a;
		int n = b.length;

		int i, j;
		float key;
		for (i = 1; i < b.length; i++) {
			key = b[i];
			j = i - 1;

			while (j >= 0 && b[j] > key) {
				b[j + 1] = b[j];
				j--;
			}
			b[j + 1] = key;
			display(b);
		}

		long end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Executed Time: " + (end - begin) + "ms");

		File f = new File("OUTPUT3.TXT");
		PrintWriter pw1 = new PrintWriter(f);
		for (float g : b) {
			pw1.print(g + " ");
		}
		pw1.flush();
		pw1.close();
		return b;
	}

	
	// hàm tim kiếm tuyến tính
	public void search(float arr[], float value) throws FileNotFoundException {
		
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] > value) {
				System.out.print(i + " ");
			}
		
		}
		System.out.println();
		File f = new File("OUTPUT4.TXT");
		PrintWriter pw1 = new PrintWriter(f);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > value) {
				pw1.print(i + " ");
			}

		}
		pw1.flush();
		pw1.close();
	}

	
	// hàm sắp xếp cho mảng tìm kiếm nhị phân
	public float[] sort(float[] b) {
		
		int n = b.length;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n - i - 1; j++) {
				if (b[j] > b[j + 1]) {

					float temp = b[j];
					b[j] = b[j + 1];
					b[j + 1] = temp;

				}
			}

			
		}
		return b;
	}
	
	// hàm tìm kiếm nhị phân
	public int binarySearch(float arr[], int left, int right, float value) throws FileNotFoundException {

		float[] b = arr;

		if (left <= right) {

		int mid = (left + right) / 2;
		if ((mid == 0 || arr[mid - 1] < value ) && value == b[mid]) {
			File f = new File("OUTPUT5.TXT");
			PrintWriter pw1 = new PrintWriter(f);
			pw1.print(mid);
			pw1.flush();
			pw1.close();
			return mid;
		} else if (value > b[mid]) {
			return binarySearch(arr, mid + 1, right, value);
		} else { // value < b[mid]
			return binarySearch(arr, left, mid - 1, value);
		}
		
		}


		File f = new File("OUTPUT5.TXT");
		PrintWriter pw1 = new PrintWriter(f);
		pw1.print("-1");
		pw1.flush();
		pw1.close();
		return -1;
	
	
	}
}
