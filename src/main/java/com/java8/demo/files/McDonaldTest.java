
package com.java8.demo.files;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class McDonaldTest {

	public static void main(String... args) throws Exception {

		Stream<String> linex = Files.lines(Paths.get("files", "mcdonalds.csv"));
		List<McDonald> mcdos = linex.map(s -> {
			String[] strings = s.split(",");
			McDonald mdo = new McDonald();
			mdo.setLatitude(Double.parseDouble(strings[0]));
			mdo.setLongitude(Double.parseDouble(strings[1]));
			mdo.setName(strings[2].substring(1) + strings[3].substring(0, strings[3].length() - 1));
			mdo.setAddress(strings[4].substring(1));
			mdo.setCity(strings[5].trim());
			mdo.setState(strings[6].trim());
			if (mdo.getState().endsWith("\"")) {
				mdo.setState(mdo.getState().substring(0, mdo.getState().length() - 1));
			}
			if (mdo.getState().contains(" ")) {
				mdo.setState(mdo.getState().substring(0, mdo.getState().indexOf(" ")));
			}
			if (mdo.getState().length() > 2) {
				mdo.setState(strings[7].trim());
			}
			return mdo;
		}).collect(Collectors.toList());

		System.out.println("# of McDos = " + mcdos.size());

		// The number of cities that have a McDonald
		long nTowns = mcdos.stream().map(McDonald::getCity).collect(Collectors.toSet()).size();
		System.out.println("The number of cities that have a McDonald : " + nTowns);

		// The city has the most MacDonald
		Map.Entry<String, Long> entry = mcdos.stream()
				.collect(Collectors.groupingBy(McDonald::getCity, Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		System.out.println("The city has the most MacDonald : " + entry);

	}
}
