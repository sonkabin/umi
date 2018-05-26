package com.sjm.service;

import java.util.List;

import com.sjm.domain.GuestBook;
import com.sjm.dto.GuestBookDTO;

public interface GuestService {

	List<GuestBook> getGuestBooks(GuestBookDTO dto);

	void deleteGuestBook(Integer id);
}
