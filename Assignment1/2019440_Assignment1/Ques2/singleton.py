from rdflib import RDF, Graph, Literal, Namespace, BNode, Bag, RDFS, URIRef, FOAF, XSD

# initialize the graph1 and bind the default IRI with it
g1 = Graph('Memory', identifier=URIRef(
    'http://iiitd.ac.in/course/sweb/student/2019440/Charlie'))
EX = Namespace("http://iiitd.ac.in/course/sweb/student/2019440/")
g1.bind("EX", EX)

# Creating the resources and blank nodes reqiured for the first graph
Question = URIRef(EX.term("Question"))
ElonMusk = URIRef(EX.term("ElonMusk"))
CharlieMunger = URIRef(EX.term("CharlieMunger"))
Tesla = URIRef(EX.term("Tesla"))
SpaceX = URIRef(EX.term("SpaceX"))
CompanyBag = BNode()
CharlieQuestionBNode = BNode()
DailyJournalMeetingBNode = BNode()
CharlieResponse = BNode()
CharlieThought1 = BNode()
CharlieThought2 = BNode()
CharlieThoughtBag = BNode()

# Adding the triples to g1
g1.add((ElonMusk, RDF.type, Literal('Billionaire', lang='en')))
g1.add((ElonMusk, EX.brilliantMindBehind, CompanyBag))
g1.add((CompanyBag, RDF.type, RDF.Bag))
g1.add((CompanyBag, RDFS.member, SpaceX))
g1.add((CompanyBag, RDFS.member, Tesla))
g1.add((Question, EX.asked, CharlieQuestionBNode))
g1.add((CharlieQuestionBNode, EX.askedTo, CharlieMunger))
g1.add((CharlieQuestionBNode, EX.askedAbout, ElonMusk))
g1.add((CharlieQuestionBNode, EX.askedAt, DailyJournalMeetingBNode))
g1.add((CharlieQuestionBNode, EX.name, Literal(
    "Daily Journal Meeting", lang='en')))
g1.add((DailyJournalMeetingBNode, EX.year, Literal(2014, datatype=XSD.gYear)))
g1.add((CharlieMunger, FOAF.firstName, Literal('Charlie', lang='en')))
g1.add((CharlieMunger, FOAF.lastName, Literal('Munger', lang='en')))
g1.add((ElonMusk, FOAF.firstName, Literal('Elon', lang='en')))
g1.add((ElonMusk, FOAF.lastName, Literal('Musk', lang='en')))
g1.add((ElonMusk, EX.type_1, Literal('Genius', lang='en')))
g1.add((EX.type_1, EX.singletonPropertyOf, RDF.type))
g1.add((EX.type_1, EX.hasSource, CharlieMunger))
g1.add((ElonMusk, EX.oneOfThe_1, Literal('Boldest', lang='en')))
g1.add((ElonMusk, EX.oneOfThe_1, Literal('Smartest', lang='en')))
g1.add((EX.oneOfThe_1, EX.singletonPropertyOf, EX.oneOfThe))
g1.add((EX.oneOfThe_1, EX.hasSource, CharlieMunger))

# Seriealizing te graph and storing it in trig format
print(g1.serialize(format='trig'), file=open('Q2_Graph2_part1.trig', 'w'))
print(g1.serialize(format='trig'), file=open('Q2_Graph2_combined.trig', 'w'))

# initialize the graph2 and bind the default IRI with it
g2 = Graph('Memory', identifier=URIRef(
    'http://iiitd.ac.in/course/sweb/student/2019440/Musk'))
g2.bind("EX", EX)

# Creating the resources and blank nodes reqiured for the second graph
IsaacAsimov = URIRef(EX.term("IsaacAsimov"))
Isaacson = URIRef(EX.term("Isaacson"))
EinsteinHisLifeandUniverse = URIRef(EX.term("EinsteinHisLifeandUniverse"))
FoundationSeries = URIRef(EX.term("FoundationSeries"))
AllTimeBests = URIRef(EX.term("AllTimeBests"))
MuskInterviewBNode = BNode()
MuskStatement1 = BNode()
MuskStatement2 = BNode()
MuskStatement3 = BNode()


# Adding the triples to g2
g2.add((ElonMusk, EX.interview, MuskInterviewBNode))
g2.add((MuskInterviewBNode, EX.interviewWith,
        Literal('Design and Architecture', lang='en')))
g2.add((IsaacAsimov, FOAF.firstName, Literal('Isaac', lang='en')))
g2.add((IsaacAsimov, FOAF.lastName, Literal('Asimov', lang='en')))
g2.add((IsaacAsimov, EX.author_1, Literal('Great', lang='en')))
g2.add((IsaacAsimov, EX.author_1, Literal('Sci-fi book', lang='en')))
g2.add((EX.author_1, EX.singletonPropertyOf, EX.author))
g2.add((EX.author_1, EX.hasSource, ElonMusk))
g2.add((FoundationSeries, EX.among_1, AllTimeBests))
g2.add((EX.among_1, EX.singletonPropertyOf, EX.among))
g2.add((EX.among_1, EX.hasSource, ElonMusk))
g2.add((ElonMusk, EX.recommends, EinsteinHisLifeandUniverse))
g2.add((EinsteinHisLifeandUniverse, EX.author, Isaacson))
g2.add((Isaacson, FOAF.lastName, Literal('Isaacson', lang='en')))


# Seriealizing te graph and storing it in trig format
print(g2.serialize(format='trig'), file=open('Q2_Graph2_part2.trig', 'w'))
print(g2.serialize(format='trig'), file=open('Q2_Graph2_combined.trig', 'a'))
