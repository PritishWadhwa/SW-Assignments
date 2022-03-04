/**
 * 
 */
package org.example;

import static org.eclipse.rdf4j.model.util.Values.literal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.rdf4j.model.BNode;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Namespace;
import org.eclipse.rdf4j.model.Triple;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.util.Models;
import org.eclipse.rdf4j.model.util.Statements;
import org.eclipse.rdf4j.model.util.Values;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.model.vocabulary.XSD;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;

/**
 * @author Pritish Wadhwa
 *
 */
public class HelloRDF4J {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/***** Part A *****/

		// Defining the custom namespace
		Namespace EX = Values.namespace("EX", "http://iiitd.ac.in/course/sweb/student/2019440/");

		// Defining the relevant Resources and Blank nodes
		IRI Question = Values.iri(EX, "Question");
		IRI ElonMusk = Values.iri(EX, "ElonMusk");
		IRI CharlieMunger = Values.iri(EX, "CharlieMunger");
		IRI Tesla = Values.iri(EX, "Tesla");
		IRI SpaceX = Values.iri(EX, "SpaceX");
		IRI IsaacAsimov = Values.iri(EX, "IsaacAsimov");
		IRI Isaacson = Values.iri(EX, "Isaacson");
		BNode CompanyBag = Values.bnode();
		BNode CharlieQuestionBNode = Values.bnode();
		BNode DailyJournalMeetingBNode = Values.bnode();
		BNode MuskInterviewBNode = Values.bnode();

		// Instantiating the model builder class to generate the graph
		ModelBuilder builder = new ModelBuilder();

		// Adding the triples in the graph
		builder.setNamespace("EX", "http://iiitd.ac.in/course/sweb/student/2019440/").subject(ElonMusk)
				.add("EX:interview", MuskInterviewBNode).add(RDF.TYPE, literal("Billionaire", "en"))
				.add("EX:brilliantMindBehind", CompanyBag).add(FOAF.FIRST_NAME, literal("Elon", "en"))
				.add(FOAF.LAST_NAME, literal("Musk", "en")).subject(CompanyBag).add(RDF.TYPE, RDF.BAG)
				.add(RDFS.MEMBER, SpaceX).add(RDFS.MEMBER, Tesla).subject(Question)
				.add("EX:asked", CharlieQuestionBNode).subject(CharlieQuestionBNode).add("EX:askedTo", CharlieMunger)
				.add("EX:askedAbout", ElonMusk).add("EX:askedAt", DailyJournalMeetingBNode)
				.add("EX:name", literal("Daily Journal Meeting", "en")).subject(DailyJournalMeetingBNode)
				.add("EX:year", literal("2014", XSD.GYEAR)).subject(CharlieMunger)
				.add(FOAF.FIRST_NAME, literal("Charlie", "en")).add(FOAF.LAST_NAME, literal("Munger", "en"))
				.subject(MuskInterviewBNode).add("EX:interviewWith", literal("Design and Architecture", "en"))
				.subject(IsaacAsimov).add(FOAF.FIRST_NAME, literal("Isaac", "en"))
				.add(FOAF.LAST_NAME, literal("Asimov", "en")).subject(Isaacson)
				.add(FOAF.LAST_NAME, literal("Isaacson", "en"));

		// Building the graph
		Model model = builder.build();
		Triple reifiedTriple = Values.triple(ElonMusk, RDF.TYPE, literal("Genius", "en"));
		model.add(Statements.statement(reifiedTriple, Values.iri(EX, "thinks"), CharlieMunger, null));
		reifiedTriple = Values.triple(ElonMusk, Values.iri(EX, "oneOfThe"), literal("Boldest", "en"));
		model.add(Statements.statement(reifiedTriple, Values.iri(EX, "thinks"), CharlieMunger, null));
		reifiedTriple = Values.triple(ElonMusk, Values.iri(EX, "oneOfThe"), literal("Smartest", "en"));
		model.add(Statements.statement(reifiedTriple, Values.iri(EX, "thinks"), CharlieMunger, null));
		reifiedTriple = Values.triple(IsaacAsimov, Values.iri(EX, "author"), literal("Great", "en"));
		model.add(Statements.statement(reifiedTriple, Values.iri(EX, "said"), ElonMusk, null));
		reifiedTriple = Values.triple(IsaacAsimov, Values.iri(EX, "author"), literal("Sci-fi book", "en"));
		model.add(Statements.statement(reifiedTriple, Values.iri(EX, "said"), ElonMusk, null));
		reifiedTriple = Values.triple(Values.iri(EX, "FoundationSeries"), Values.iri(EX, "among"),
				literal("All-time best", "en"));
		model.add(Statements.statement(reifiedTriple, Values.iri(EX, "likes"), ElonMusk, null));
		reifiedTriple = Values.triple(Values.iri(EX, "EinsteinHisLifeandUniverse"), Values.iri(EX, "EwrittenBy"),
				Isaacson);
		model.add(Statements.statement(reifiedTriple, Values.iri(EX, "recommends"), ElonMusk, null));

		// Binding the namespaces with the graph
		model.setNamespace(RDF.NS);
		model.setNamespace(RDFS.NS);
		model.setNamespace(FOAF.NS);
		model.setNamespace(EX);

		// Converting the created reifications to rdf star
		Model convertedModel = Models.convertReificationToRDFStar(model);

		// Printing the model on console
		Rio.write(convertedModel, System.out, RDFFormat.TURTLESTAR);

		/***** Part B *****/

		// Saving the rdf star triples in .ttls format
//		FileOutputStream ttlsFormat = new FileOutputStream("./target/classes/org/example/reifiedTriples.ttls");
		FileOutputStream ttlsFormat = new FileOutputStream("reifiedTriples.ttls");
		try {
			Rio.write(convertedModel, ttlsFormat, RDFFormat.TURTLESTAR);
		} finally {
			ttlsFormat.close();
		}

		// Reading the rdf star file
		String fileName = "reifiedTriples.ttls";
		InputStream input = HelloRDF4J.class.getResourceAsStream("/" + fileName);
		Model loadedModel = Rio.parse(input, "", RDFFormat.TURTLESTAR);

		// Converting the rdf star triples to Reified Triples
		convertedModel = Models.convertRDFStarToReification(loadedModel);

		// Printing the reified triples on console
		System.out.println("\n\n\n\nRDF Star Model converted to Reification");
		Rio.write(convertedModel, System.out, RDFFormat.TURTLE);

		// Converting the reified triples back to RDF Star
		convertedModel = Models.convertReificationToRDFStar(convertedModel);

		// Printing the rdf star triples on console
		System.out.println("\n\n\n\nRDF Star Model converted to Reification");
		Rio.write(convertedModel, System.out, RDFFormat.TURTLESTAR);

	}

}
