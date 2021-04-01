package com.string.palindrome.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.string.palindrome.controller.dao.StringRepository;
import com.string.palindrome.controller.model.StringDTO;

@Component
public class StringService {

	@Autowired
	private StringRepository repo;

	public void saveLargestPalindromeSubstring(String inputString) {

		String palinSubstr = largestPalindromeSubstring(inputString);
		
		StringDTO stringDtl = new StringDTO();
		stringDtl.setInputString(inputString);
		stringDtl.setPalindromeSubstring(palinSubstr);

		repo.save(stringDtl);
	}

	private String largestPalindromeSubstring(String inputString) {

		// The result (length of LPS)
		int maxLength = 1;

		int start = 0;
		int len = inputString.length();

		int low;
		int high;

		// One by one consider every
		// character as center
		// point of even and length
		// palindromes
		for (int i = 1; i < len; ++i) {
			// Find the longest even
			// length palindrome with
			// center points as i-1 and i.
			low = i - 1;
			high = i;
			while (low >= 0 && high < len
					&& inputString.charAt(low)
					== inputString.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}

			// Find the longest odd length
			// palindrome with center point as i
			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < len
					&& inputString.charAt(low)
					== inputString.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
		}

		String palinSubstr = inputString.substring(
				start, start + maxLength);

		System.out.println("Longest palindrome substring is : " + palinSubstr);

		return palinSubstr;
	}
	
	public List<StringDTO> getAllSavedData() {
		
		return repo.findAll();
	}
	
	public List<StringDTO> findPalindromeOfString(String inputString)
	{
		return repo.findByInputString(inputString);
	}
}
