package com.string.palindrome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.string.palindrome.controller.model.StringDTO;
import com.string.palindrome.controller.service.StringService;

@RestController
@RequestMapping(value = "/string", produces = { MediaType.APPLICATION_JSON_VALUE })
public class StringController {

	@Autowired
	private StringService stringService;

	@PostMapping("/savePalindrome")
	public String saveLongestSubstringPalindrome(@RequestParam String inputString)
	{

		stringService.saveLargestPalindromeSubstring(inputString);

		return "Data saved successfully.";
	}
	
	@GetMapping("/getAllStringAndPalindrome")
	public List<StringDTO> getAllStringAndPalindromes()
	{
		return stringService.getAllSavedData();
	}
	
	@GetMapping("/getPalindromeOfString")
	public List<StringDTO> getPalindromeOfString(@RequestParam String inputString)
	{
		return stringService.findPalindromeOfString(inputString);
	}
}
