package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Process {
	static List<String> pro = new ArrayList<String>();

	public static class GetProcess {

		@SuppressWarnings("unused")
		public static int listRunningProcesses() {
			List<String> processes = new ArrayList<String>();
			int count = 0;
			try {
				String line;
				java.lang.Process p = Runtime.getRuntime().exec("tasklist.exe /nh");
				BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = input.readLine()) != null) {
					if (!line.trim().equals("")) {
						processes.add(line.substring(0, line.indexOf(" ")));
					}

				}
				input.close();
			} catch (Exception err) {
				err.printStackTrace();
			}

			String result = "";
			String vaue = "";
			for (int i = 0; i <= processes.size() - 1; i++) {
				vaue = processes.get(i);
				if (vaue.equalsIgnoreCase("compose.exe")) {
					count++;
				}
			}

			return count;
		}

	}

	public static void main(String[] args) throws IOException {
		Process a = new Process();
		GetProcess.listRunningProcesses();

	}
}
		
