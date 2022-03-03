from rdflib import Graph

# taking the input file and output format from the user

inputFile = input("Enter the input file name: ")
outputFormat = input("Enter the output format: ")

availFileFormats = {
    ".ttl": "turtle",
    ".nt": "nt",
    ".n3": "n3",
    ".rdf": "xml"
}

# Checking if the input file format and output file format are available in the dictionary
inputFormat = inputFile[inputFile.rfind("."):]
if outputFormat[0] != '.':
    outputFormat = '.' + outputFormat
if inputFormat not in availFileFormats:
    print("Invalid input file")
    exit()
if outputFormat not in availFileFormats:
    print("Invalid output format")
    exit()


# creating a graph object and parsing it with the input file
g = Graph()
g.parse(inputFile, availFileFormats[inputFormat])

# Serializing the graph and storing it in the required file format
g.serialize(destination=inputFile[:inputFile.rfind(
    ".")] + outputFormat, format=availFileFormats[outputFormat], encoding="utf-8")
