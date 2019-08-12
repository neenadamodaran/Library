package com.neena.library.web.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neena.library.model.Book;

public class BookValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Book.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "authorName", "authorName.empty");
		ValidationUtils.rejectIfEmpty(errors, "bookName", "bookName.empty");
		ValidationUtils.rejectIfEmpty(errors, "bookVersion", "bookVersion.empty");
		ValidationUtils.rejectIfEmpty(errors, "publicationDate", "publicationDate.empty");
		ValidationUtils.rejectIfEmpty(errors, "bookInventory.quantity", "bookInventory.quantity.empty");

		Book book = (Book) target;
		if (book.getBookInventory().getQuantity() <= 0) {

			errors.rejectValue("bookInventory.quantity", "bookInventory.quantity.invalid");

		}
		if (book.getPublicationDate() != null) {
			System.out.println("Publication Date " + book.getPublicationDate() );
			System.out.println("Publication Date " + Calendar.getInstance().getTime().toString());
			SimpleDateFormat sdf = new SimpleDateFormat( "EEE MMM dd HH:mm:ss z yyyy");

			try {
				Date date1 = sdf.parse(book.getPublicationDate().toString());
				Date date2 = sdf.parse(Calendar.getInstance().getTime().toString());
				System.out.println("date2" + date2);
				if (date1.after(date2)) {
					errors.rejectValue("publicationDate", "publicationDate.moreThanCurrentDate");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
