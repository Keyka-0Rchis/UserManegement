package repository;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class IdGenerator {	
	public static int generateNextID(Set<Integer> generatedIdSet) {
		int nextID;
		Optional<Integer> maxId = generatedIdSet.stream()
									.max(Comparator.naturalOrder());
		if(maxId.isPresent()) {
			nextID = maxId.get() + 1;
		}else {
			nextID = 1;
		}
		return nextID;
	}
}
