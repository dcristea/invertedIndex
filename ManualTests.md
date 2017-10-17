Prerequisites : 
- documents are proivided and located in resource/documnets folder; Stopwords files are also provided and are located in resource folder
- provide stopwords_en.txt file that will be located in the resource folder
- provide a jpeg file in the resource/documents folder
- provide a pdf file in the resource/documents folder
- provide a doc file in the resource/documents folder
- provide stopwords_en.txt file that will be located in the resource folder

Test_01_Successful indexing of a txt file
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter a valid path where the documents are located
	  
	  Expected result : Verify that 2 txt files are indexed (Earth.txt and System.txt)
	  Output should look like this : 
	  indexed C:\Work\workspace\homework\src\main\resources\documents\Earth.txt 495 words
      indexed C:\Work\workspace\homework\src\main\resources\documents\System.txt 495 words

Test_02_Unsuccessful indexing of a jpeg file
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter a valid path where the documents are located
	  
	  Expected result : Verify that again only 2 txt files are indexed (Earth.txt and System.txt)

Test_03_Usuccessful indexing when an invalid folder is provided
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter an invalid path(e.g. /usr/home/)
	  
	  Expected result : Verify that the build fails and no file is indexed

Test_04_Unsuccessful indexing of a pdf file
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter a valid path where the documents are located
	  
	  Expected result : Verify that again only 2 txt files are indexed (Earth.txt and System.txt)
	  
Test_05_Unsuccessful indexing of a doc file
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter a valid path where the documents are located
	  
	  Expected result : Verify that again only 2 txt files are indexed (Earth.txt and System.txt)

Test_06_Usuccessful indexing when an empty string is provided
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Press the enter keyboard
	  
	  Expected result : Verify that the build fails and no file is indexed

Test_07_No txt file is indexed in case the path doesn't contain any txt files
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter a valid path where no txt documents are located
	  
	  Expected result : Verify that there is not files indexed
	  

Test_08_Verify that the stopwords_en.txt file is valid
Steps:
      1.Go to the location of the stopwords_en.txt file and open the file
	  
	  Expected result : Verify that the file is valid and that it contains the selected stopwords

Test_09_Successful search of one word in the indexed files
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter a valid path where the documents are located
	  5.Verify that 2 files are indexed
	  6.A user input message is displayed on the screen : Enter search words
	  7.Enter a valid word (e.g. planet)
	  
	  Expected result : Verify that the "planet" word is found in both txt files
	  The output should look like this :
	  planet C:\Work\workspace\homework\src\main\resources\documents\Earth.txt
      planet C:\Work\workspace\homework\src\main\resources\documents\System.txt
	  
Test_10_Successful search of multiple words in the indexed files
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter a valid path where the documents are located
	  5.Verify that 2 files are indexed
	  6.A user input message is displayed on the screen : Enter search words
	  7.Enter multiple words separated by space (e.g. planet divided earth)
	  
	  Expected result :Verify that the words are found in both txt files 
	  
	  Output result:
	  planet C:\Work\workspace\homework\src\main\resources\documents\Earth.txt
      planet C:\Work\workspace\homework\src\main\resources\documents\System.txt

      divided C:\Work\workspace\homework\src\main\resources\documents\Earth.txt
      divided C:\Work\workspace\homework\src\main\resources\documents\System.txt

      earth C:\Work\workspace\homework\src\main\resources\documents\Earth.txt
      earth C:\Work\workspace\homework\src\main\resources\documents\System.txt
	  
Test_11_Successful search of one word in the indexed files with capslock enabled
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter a valid path where the documents are located
	  5.Verify that 2 files are indexed
	  6.A user input message is displayed on the screen : Enter search words
	  7.Enter a valid word with capital letters (e.g. PLANET)
	  
	  Expected result : Verify that the "planet" word is found in both txt files
	  The output should look like this :
	  planet C:\Work\workspace\homework\src\main\resources\documents\Earth.txt
      planet C:\Work\workspace\homework\src\main\resources\documents\System.txt

Test_12_Unsuccessful search of a word that is not in the indexed files
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter a valid path where the documents are located
	  5.Verify that 2 files are indexed
	  6.A user input message is displayed on the screen : Enter search words
	  7.Enter a word that is not in the indexed files
	  
	  Expected result : Verify that the word is not found and the following message is displayed on the screen:"Search words not found"
	 
Test_13_Unsuccessful search of an empty string in the indexed files
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter a valid path where the documents are located
	  5.Verify that 2 files are indexed
	  6.A user input message is displayed on the screen : Enter search words
	  7.Enter an empty string by pressing the Enter key
	  
	  Expected result : Verify that the word is not found and the following message is displayed on the screen:"Search words not found"
	  

Test_14_Unsuccessful search of multiple words separated by a regex that is not space
Steps:
      1.Go in the root of the project and open a command line interface
	  2.Execute progam by running the command line : mvn exec:java
	  3.A user input message is displayd : Enter file path where documents are located:
	  4.Enter a valid path where the documents are located
	  5.Verify that 2 files are indexed
	  6.A user input message is displayed on the screen : Enter search words
	  7.Enter a list of 3 words separated by "," (e.g. planet,divided,earth)
	  
	  Expected result : Verify that the words are not found and the message "Search words not found" is displayed on the screen
















