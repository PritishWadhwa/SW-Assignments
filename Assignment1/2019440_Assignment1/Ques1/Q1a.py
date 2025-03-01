from rdflib import Graph, URIRef, Literal, BNode, Namespace, XSD, collection, RDF, Bag, RDFS

# Defining the custom namespace
EX = Namespace("http://iiitd.ac.in/course/sweb/student/2019440/")

# Initialising the graph and binding the namespace with it
g = Graph()
g.bind("EX", EX)

# Creating the required resources and blank nodes
LandCruiser = URIRef(EX.term("Land_Cruiser"))
Vehicle = URIRef(EX.term("Vehicle"))
VehicleBrands = URIRef(EX.term("Vehicle_Brands"))
FourWheeler = URIRef(EX.term("4_Wheeler"))
ThreeWheeler = URIRef(EX.term("3_Wheeler"))
TwoWheeler = URIRef(EX.term("2_Wheeler"))
ElectricVehicle = URIRef(EX.term("Electric_Vehicle"))
Cars = URIRef(EX.term("Cars"))
Suv = URIRef(EX.term("SUV"))
Toyota = URIRef(EX.term("Toyota"))
Japan = URIRef(EX.term("Japan"))
NorthAmerica = URIRef(EX.term("North_America"))
Asia = URIRef(EX.term("Asia"))
TokyoCity = URIRef(EX.term("Tokyo_City"))
Aichi = URIRef(EX.term("Aichi"))
Volkswagon = URIRef(EX.term("Volkswagon"))
Ford = URIRef(EX.term("Ford"))
Hyundai = URIRef(EX.term("Hyundai"))
EVReason = BNode()
LandCruiserSales = BNode()
LandCruiserFirstGenProduction = BNode()
ToyotaHeadquarters = BNode()
ToyotaHistory = BNode()
ToyotaFounder = BNode()
ToyotaFocussedProduction = BNode()
market1 = BNode()
market2 = BNode()
market3 = BNode()
bodyStyleBag = BNode()
competitorsBag = BNode()
manufactureBag = BNode()


# adding the triples to the graph
g.add((Vehicle, RDF.type, RDFS.Class))
g.add((VehicleBrands, RDF.type, RDFS.Class))
g.add((FourWheeler, RDFS.subClassOf, Vehicle))
g.add((ThreeWheeler, RDFS.subClassOf, Vehicle))
g.add((TwoWheeler, RDFS.subClassOf, Vehicle))
g.add((ElectricVehicle, RDFS.subClassOf, FourWheeler))
g.add((ElectricVehicle, RDFS.subClassOf, ThreeWheeler))
g.add((ElectricVehicle, RDFS.subClassOf, TwoWheeler))
g.add((Cars, RDFS.subClassOf, FourWheeler))
g.add((Suv, RDFS.subClassOf, FourWheeler))
g.add((LandCruiser, RDF.type, Suv))
g.add((LandCruiser, EX.alternateSpelling, Literal("LandCruiser", lang="en")))
g.add((LandCruiser, EX.alternateSpelling, Literal("Land Cruiser", lang="en")))
g.add((LandCruiser, EX.alternateName, Literal(
    "Toyota Rando-Kurūzā", lang="Hepburn")))
g.add((LandCruiser, EX.alternateName, Literal("Toyota Land Cruiser", lang="en")))
g.add((LandCruiser, EX.parentCompany, Toyota))
g.add((Toyota, EX.fullName, Literal("Toyota Motor Corporation", datatype=XSD.string)))
g.add((Toyota, EX.countryOfOrigin, Japan))
g.add((Toyota, EX.domain, Literal("Automobile Manufacturer", lang="en")))
g.add((LandCruiser, EX.sales, LandCruiserSales))
g.add((LandCruiserSales, EX.tillYear, Literal(2019, datatype=XSD.gYear)))
g.add((LandCruiserSales, EX.unitsSold, Literal(10000000, datatype=XSD.integer)))
g.add((LandCruiserSales, EX.whereSold, Literal("Worldwide", datatype=XSD.string)))
g.add((LandCruiser, EX.productionOf, LandCruiserFirstGenProduction))
g.add((LandCruiserFirstGenProduction, EX.startYear,
       Literal(1951, datatype=XSD.gYear)))
g.add((LandCruiserFirstGenProduction, EX.modelName,
       Literal("First Generation Land Cruiser", lang="en")))
g.add((LandCruiser, EX.bodyStyleProduced, bodyStyleBag))
g.add((bodyStyleBag, RDF.type, RDF.Bag))
g.add((bodyStyleBag, RDFS.member, Literal("Hardtop", lang="en")))
g.add((bodyStyleBag, RDFS.member, Literal("Station Wagon", lang="en")))
g.add((bodyStyleBag, RDFS.member, Literal("Cab Chassis", lang="en")))
g.add((bodyStyleBag, RDFS.member, Literal("Convertible", lang="en")))
# using bags
g.add((Toyota, EX.majorCompetitors, competitorsBag))
g.add((competitorsBag, RDF.type, RDF.Bag))
g.add((competitorsBag, RDFS.member, Ford))
g.add((competitorsBag, RDFS.member, Hyundai))
g.add((competitorsBag, RDFS.member, Volkswagon))
g.add((Toyota, EX.manufactures, manufactureBag))
g.add((manufactureBag, RDF.type, RDF.Bag))
g.add((manufactureBag, RDFS.member, Suv))
g.add((manufactureBag, RDFS.member, Cars))
g.add((manufactureBag, RDFS.member, ElectricVehicle))
g.add((Toyota, RDFS.subClassOf, VehicleBrands))
g.add((Ford, RDFS.subClassOf, VehicleBrands))
g.add((Hyundai, RDFS.subClassOf, VehicleBrands))
g.add((Volkswagon, RDFS.subClassOf, VehicleBrands))
g.add((Ford, EX.manufactures, Cars))
g.add((Hyundai, EX.manufactures, Cars))
g.add((Volkswagon, EX.manufactures, Cars))
g.add((Toyota, EX.headquarters, ToyotaHeadquarters))
g.add((ToyotaHeadquarters, EX.city, TokyoCity))
g.add((ToyotaHeadquarters, EX.prefecture, Aichi))
g.add((ToyotaHeadquarters, EX.country, Japan))
g.add((Toyota, EX.historicalInformation, ToyotaHistory))
g.add((ToyotaHistory, EX.foundedBy, ToyotaFounder))
g.add((ToyotaFounder, EX.firstName, Literal("Kiichiro", lang="jp")))
g.add((ToyotaFounder, EX.lastName, Literal("Toyoda", lang="jp")))
g.add((ToyotaHistory, EX.incorporationDate,
       Literal('1937-08-28', datatype=XSD.date)))
g.add((Toyota, EX.longestRunningSeriesOfModels, LandCruiser))
g.add((Toyota, EX.currentFocusOn, Literal('Sustainable Growth', lang="en")))
g.add((Toyota, EX.currentFocusOn, ToyotaFocussedProduction))
g.add((ToyotaFocussedProduction, EX.productionOf, ElectricVehicle))
g.add((ToyotaFocussedProduction, EX.reason, EVReason))
g.add((EVReason, EX.impactOn, Literal("Environment", lang="en")))
g.add((EVReason, EX.intensity, Literal("Very Low", lang="en")))
# using list
g.add((Toyota, EX.market, market1))
g.add((market1, RDF.first, NorthAmerica))
g.add((market1, RDF.rest, market2))
g.add((market2, RDF.first, Japan))
g.add((market2, RDF.rest, market3))
g.add((market3, RDF.first, Asia))
g.add((market3, RDF.rest, RDF.nil))

# generating the output in .ttl format
g.serialize(destination='Q1a_output.ttl', format='turtle')
