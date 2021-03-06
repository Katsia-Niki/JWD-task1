package by.jwd.task0.reader.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task0.validator.StringValidator;
import by.jwd.task0.validator.impl.StringValidatorImpl;
import by.jwd.task0.exception.CustomArrayException;
import by.jwd.task0.reader.CustomFileReader;

public class CustomFileReaderImpl implements CustomFileReader{

	static Logger logger = LogManager.getLogger();
	private static final String EMPTY_STRING = "";

	@Override
	public String readOneLineFromFile(String pathToFile) throws CustomArrayException {

		StringValidator validator = StringValidatorImpl.getInstance();

		String currentLine = EMPTY_STRING;


		try(BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {

			boolean isCorrectLine = false;

			while (!isCorrectLine && (currentLine = reader.readLine()) != null) {
				isCorrectLine = validator.validateString(currentLine);
			}

			if (currentLine == null) {
				currentLine = EMPTY_STRING;
			}

		} catch (FileNotFoundException e) {
			logger.error("File " + pathToFile + " was not found", e);
			throw new CustomArrayException("File " + pathToFile + " was not found", e);

		} catch (IOException e) {
			logger.error("File " + pathToFile + " can't be open", e);
			throw new CustomArrayException("File " + pathToFile + " can't be open", e);
		}

		logger.log(Level.INFO, "This data " + currentLine + " are correct.");
		return currentLine;
	}


	@Override
	public List<String> readFromFile(String pathToFile) throws CustomArrayException {
		StringValidator validator = StringValidatorImpl.getInstance();

		List<String> listInts = new ArrayList<>();

		try(BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {

			String currentLine;

			while ((currentLine = reader.readLine()) != null) {
				if (validator.validateString(currentLine)) {
					listInts.add(currentLine);
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("File " + pathToFile + " was not found", e);
			throw new CustomArrayException("File " + pathToFile + " was not found", e);

		} catch (IOException e) {
			logger.error("File " + pathToFile + " can't be open", e);
			throw new CustomArrayException("File " + pathToFile + " can't be open", e);
		}

		return listInts;
	}

}
