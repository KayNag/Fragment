package kay.fragment.fragments;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

 class Sort implements Comparator<Map<String, String>>
{
    private final String key;

    public Sort(String txt)
    {
        this.key = txt;
    }

   
	@Override
	public int compare(Map<String, String> lhs, Map<String, String> rhs) {
		  // TODO: Null checking, both for maps and values
        String firstValue = lhs.get(key);
        String secondValue = rhs.get(key);
        return firstValue.compareTo(secondValue);
	}
}