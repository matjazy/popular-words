# popular-words
## Description
This repository was created for recruitment purposes and contains practical task to do.
Task is an authentic request of an Englishman. It is also a good case to check many technical and analytical skills. 

## Task
I need a simple program, that will find the first 1000 most popular words in a file **3esl.txt** (this file is saved in a resource directory and was downloaded from a page http://wordlist.aspell.net/12dicts from 12dicts-5.0.zip archive file)

Please compare your results with an index frequency file created by Adam Kilgarriff in a file **all.num** (this file is saved in test resource directory and was downloaded from a page 
https://www.kilgarriff.co.uk/bnc-readme.html and extracted from a all.num.gz archive file)

To create a result for this task please:
- Clone this repository to your own GitHub repository. 
- Create feature branch for all changes
- Create a Pull Request to develop branch which will contain all changes
- Send me a link to your GitHub repository

Please be accurate and attentive and include all corner cases. Good luck!

## Technical info
Project requires:
- Java SE 12
- Maven at least v3.5.0

##Using spark for data getting
data = sc.textFile('Kolokwium - grupa C - dane.csv')
splitData = data.map(lambda l: l.split(','))
sexandIP = splitData.map(lambda n: (str(n[5]),str(n[4])))
sexandIP = sexandIP.filter(lambda l:'gender' not in l)
maleIP = sexandIP.filter(lambda l:'Female' not in l)
splitedMaleIP = maleIP.map(lambda n: n[0]).map(lambda l: l.split('.'))
reconnectedSplitedMaleIP= splitedMaleIP.map(lambda n: (str(n[0]),str(n[1]))).map(lambda n: n[0]+'.'+n[1])
reconnectedSplitedMaleIP.map(lambda n: (n,1)).reduceByKey(lambda v1,v2: v1 + v2).filter(lambda n: n[1] >=2).collect()
