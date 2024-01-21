import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problems
{
    public static void main(String args[])
    {
        int[] nums = {2,11,7,15};
        int target = 9;
        System.out.println(problem1(nums, target));
        int x = -121;
        System.out.println(problem2(x));
        String[] input = {"flower", "flow", "flight"};
        System.out.println(problem3(input));
        String roman = "IX";
        System.out.println(problem4(roman));
        String s = "()[]{}";
        System.out.println(problem5(s));
        int list1[] = {1,2,4};
        int list2[] = {1,3,4};
        System.out.println(problem6(list1, list2));
        int digits[] ={1,2,9};
        System.out.println(problem7(digits));
    }
    public static String problem1(int[] nums, int target)
    {
        int[] output = {0,0};
        for(int i = 0; i < nums.length-1; i++)
        {
            for(int j = 0; j < nums.length-1; j++) {
                if(i==j)
                    j++;
                if (nums[i] + nums[j] == target) {
                    output[0] = nums[i];
                    output[1] = nums[j];
                }
            }
        }
        return("Problem 1: " + output[0] + " and " + output[1]);
    }

    public static String problem2(int x)
    {
        boolean palendrome = false;
        String s = String.valueOf(x);
        String y = "";
        if(x > 0) {
            for (int i = s.length() - 1; i >= 0; i--) {
                y += s.charAt(i);
            }
            int z = Integer.parseInt(y);
            if (x == z)
                palendrome = true;
        }
        else
            y += x;
        return("Problem 2: " + y+", "+palendrome);
    }

    public static String problem3(String[] input)
    {
        String output = "";
        int smallest = 100;
        boolean yes = false;
        for(int i = 0; i < input.length-1; i++)
        {
            if(input[i].length() < smallest)
                smallest = input[i].length();
        }
        for (int i = 0; i < smallest; i++)
        {
            char currentChar = input[0].charAt(i);
            for (int j = 1; j < input.length; j++)
            {
                if (input[j].charAt(i) != currentChar)
                    return("Problem 3: " + output);
            }
            output += (currentChar);
        }
        return("Problem 3: " + output);
    }

    public static String problem4(String roman)
    {
        int num = 0;
        for (int i = 0; i < roman.length(); i++)
        {
            char currentChar = roman.charAt(i);
            int currentValue = getValue(currentChar);
            if (i + 1 < roman.length())
            {
                int nextValue = getValue(roman.charAt(i + 1));
                if (currentValue < nextValue)
                {
                    num += (nextValue - currentValue);
                    i++;
                }
                else
                    num += currentValue;
            }
            else
                num += currentValue;
        }
        return "Problem 4: " + num;
    }

    private static int getValue(char romanChar)
    {
        switch (romanChar)
        {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static String problem5(String s)
    {
        boolean output = true;
        for(int i = 0; i < s.length()-1; i+=2)
        {
            if(s.charAt(i) == '(' && s.charAt(i+1) != ')')
            {
                output = false;
            }
            else if(s.charAt(i) == '[' && s.charAt(i+1) != ']')
            {
                output = false;
            }
            else if(s.charAt(i) == '{' && s.charAt(i+1) != '}')
            {
                output = false;
            }
            else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')
            {
                output = false;
            }
        }
        return("Problem 5: " + output);
    }


    public static String problem6(int[] list1, int[] list2)
    {
        Arrays.sort(list1);
        Arrays.sort(list2);
        List<Integer> list3 = new ArrayList<Integer>();
        for(int i = 0; i < list1.length; i++)
        {
            list3.add(list1[i]);
        }
        for(int i = 0; i < list2.length; i++)
        {
            list3.add(list2[i]);
        }
        Collections.sort(list3);
        return("Problem 6: " + list3);
    }

    public static String problem7(int[] digits)
    {
        digits[digits.length-1] = digits[digits.length-1]+1;
        incrementArray(digits);
        String s = "[";
            for (int i = 0; i < digits.length; i++)
            {
                s += digits[i];
                if (i < digits.length - 1)
                    s += ",";
            }
        s+="]";
        return("Problem 7: "+ s);
    }

    public static void incrementArray(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 10) {
                array[i] = 0;
                if (i - 1 >= 0) {
                    array[i - 1] = array[i - 1] + 1;
                }
            }
        }
    }
}
