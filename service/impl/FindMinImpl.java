package by.jwd.pretask1.service.impl;

import by.jwd.pretask1.entity.CustomArray;
import by.jwd.pretask1.service.FindMin;

public class FindMinImpl implements FindMin{

	@Override
	public int findMin(CustomArray custArr) {
		int[] array = custArr.getArray();
		int min = array[0];
		
		for(int i : array) {
			if (i < min) {
				min = i;
			}
		}
			return min;
	}

}