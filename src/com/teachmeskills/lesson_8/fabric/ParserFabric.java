package com.teachmeskills.lesson_8.fabric;

import com.teachmeskills.lesson_8.document_parser.IParser;
import com.teachmeskills.lesson_8.document_parser.impl.PdfDocumentParser;
import com.teachmeskills.lesson_8.document_parser.impl.TxtDocumentParser;
import com.teachmeskills.lesson_8.document_parser.impl.DocxDocumentParser;

public class ParserFabric {

    static public IParser createParser(String fileName){
        if(fileName == null || fileName.isEmpty()) { // проверка строки на null или пустоту
            throw new IllegalArgumentException("File is null or is empty.");
        }
        if(fileName.endsWith(".docx")){
            return new DocxDocumentParser();
            // TODO избавиться от return null и сделать возврат docx парсера +
        } else if (fileName.endsWith(".pdf")) {
            return new PdfDocumentParser();
        } else if(fileName.endsWith(".txt")){
            return new TxtDocumentParser();
        }else{
            throw new UnsupportedOperationException("Unsupported file: " + fileName);
        }
        // TODO (опционально) * попробовать переписать на конструкцию switch-case, может это будет более ёмкая запись
    }
}
