**Sentiment Analysis of Evaluations**
This project performs sentiment analysis of product reviews using an artificial intelligence model via integration with the OpenAI API. The main objective is to process text files containing reviews, generate a summary, identify strengths and weaknesses and classify the overall sentiment as **positive**, **neutral** or **negative**.
## 📋 **Summary**
- [Prerequisites]()
- [Installation and Configuration]()
- [Execution]()
- [Project Structure]()
- [Technologies Used]()
- [Author]()

## ✨ **Pre-requisites**
To run the project, you will need:
- **Java 17** or higher installed
- **Maven** (for dependency management)
- An **OpenAI API key** (saved in an environment variable called `OPENAI_API_KEY`)
- IntelliJ IDEA (optional, but recommended for development)
- Git (optional, for versioning)

## ⚙️ **Installation and Configuration**
Follow the steps below to set up the project on your machine:
### 1. Clone the repository
Use the command below to copy the project to your local machine:
``` bash
git clone https://github.com/seuusuario/seurepositorio.git
```
### Configure the environment variable
Add your OpenAI API key to the `OPENAI_API_KEY` environment variable.

### 3. Install the project dependencies
Navigate to the project directory and run Maven to download the dependencies:
``` bash
mvn clean install
```
## ▶️ **Run**
After setting up the environment, you can run the project by following these steps:
1. Make sure that the text files for the evaluations are in the directory:
``` 
   src/main/resources/evaluations
```
Example evaluation files:
``` 
   evaluation1.txt
   evaluation2.txt
   ...
```
1. run the `SentimentAnalysis` class.

1. The results will be saved in:
``` 
   src/main/resources/analyses/
```
## 🗂️ **Project Structure**
The main structure of the project is organized as follows:
``` 
.
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── en.com.alura.ecommerce/
│ │ │ ├── AnaliseDeSentimentos.java # Main class
│ │ │ ├── FileLoader.java # Deals with files
│ │ │ ├── FeelingsAnalyzer.java # Integration with OpenAI API
│ │ │ ├── SalvadorDeArquivos.java # Handles the output of the analysis
│ │ ├── resources/
│ │ ├── evaluations/ # Directory for input files
│ │ │ ├── analyzes/ # Directory for saving the results
├── .gitignore # Ignore sensitive/irrelevant files
├── pom.xml # Maven dependency manager
└── README.md # Project documentation
```
## 🛠️ **Technologies Used**
The project was carried out using the following technologies and tools:
- **Java 17:** Programming language to develop the application.
- **Maven:** Dependency management.
- OpenAI API:** AI model for natural language processing.
- IntelliJ IDEA:** IDE for development.
- Git:** Version control.

## 📌 **Main Features**
1. **Processing Assessments in Text Files:**
    - The `.txt` files placed in the `src/main/resources/evaluations` directory are processed line by line.

2. **Sentiment Analysis via OpenAI:**
    - Integration with the GPT-4 API to detect general sentiment (**positive**, **neutral** or **negative**).
    - Indication of **strong points** and **weak points** in evaluations.

3. **Generating Analysis Reports
    - The results are stored in the `src/main/resources/analyses` directory in `.txt` files.

## ⚠️ **Good Security Practices**
- Do not expose the API Key:** Make sure that the file containing your OpenAI key (`.env` or configuration on the system) is listed in `.gitignore` and never versioned.
- Review commits:** Review the commit history (`git log`) before pushing to ensure that you haven't included sensitive data in the versioned code.


## 📖 **License**
This project is developed for educational purposes and does not have a specific license.
