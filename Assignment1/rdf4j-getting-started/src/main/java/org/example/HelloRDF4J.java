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
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.sail.memory.MemoryStore;

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
		Repository rep = new SailRepository(new MemoryStore());
		Namespace EX = Values.namespace("EX", "http://iiitd.ac.in/course/sweb/student/2019440/");
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
		BNode CharlieResponse = Values.bnode();
		BNode CharlieThought1 = Values.bnode();
		BNode CharlieThought2 = Values.bnode();
		BNode CharlieThoughtBag = Values.bnode();
		BNode MuskInterviewBNode = Values.bnode();
		BNode MuskStatement1 = Values.bnode();
		BNode MuskStatement2 = Values.bnode();
		BNode MuskStatement3 = Values.bnode();

		ModelBuilder builder = new ModelBuilder();
		// builder.setNamespace("EX",
		// "http://iiitd.ac.in/course/sweb/student/2019440/").subject(ElonMusk)
		// .add("EX:interview", MuskInterviewBNode).add(RDF.TYPE, literal("Billionaire",
		// "en"))
		// .add("EX:brilliantMindBehind", CompanyBag).add(FOAF.FIRST_NAME,
		// literal("Elon", "en"))
		// .add(FOAF.LAST_NAME, literal("Musk", "en")).subject(CompanyBag).add(RDF.TYPE,
		// RDF.BAG)
		// .add(RDFS.MEMBER, SpaceX).add(RDFS.MEMBER, Tesla).subject(Question)
		// .add("EX:asked",
		// CharlieQuestionBNode).subject(CharlieQuestionBNode).add("EX:askedTo",
		// CharlieMunger)
		// .add("EX:askedAbout", ElonMusk).add("EX:askedAt", DailyJournalMeetingBNode)
		// .add("EX:name", literal("Daily Journal Meeting",
		// "en")).subject(DailyJournalMeetingBNode)
		// .add("EX:year", literal("2014", XSD.GYEAR)).subject(CharlieMunger)
		// .add(FOAF.FIRST_NAME, literal("Charlie", "en")).add(FOAF.LAST_NAME,
		// literal("Munger", "en"))
		// .add("EX:response",
		// CharlieResponse).subject(CharlieResponse).add("EX:thinks", CharlieThoughtBag)
		// .subject(CharlieThoughtBag).add(RDF.TYPE, RDF.BAG).add(RDFS.MEMBER,
		// CharlieThought1)
		// .add(RDFS.MEMBER, CharlieThought2).subject(CharlieThought1).add(RDF.SUBJECT,
		// ElonMusk)
		// .add(RDF.PREDICATE, RDF.TYPE).add(RDF.OBJECT, literal("Genius",
		// "en")).subject(CharlieThought2)
		// .add(RDF.SUBJECT, ElonMusk).add(RDF.PREDICATE, "EX:oneOfThe").add(RDF.OBJECT,
		// literal("Boldest", "en"))
		// .add(RDF.OBJECT, literal("Smartest", "en")).subject(MuskInterviewBNode)
		// .add("EX:interviewWith", literal("Design and Architecture",
		// "en")).add("EX:said", MuskStatement1)
		// .add("EX:likes", MuskStatement2).add("EX:recommends",
		// MuskStatement3).subject(IsaacAsimov)
		// .add(FOAF.FIRST_NAME, literal("Isaac", "en")).add(FOAF.LAST_NAME,
		// literal("Asimov", "en"))
		// .subject(MuskStatement1).add(RDF.SUBJECT, IsaacAsimov).add(RDF.PREDICATE,
		// "EX:author")
		// .add(RDF.OBJECT, literal("Great", "en")).add(RDF.OBJECT, literal("Sci-fi
		// book", "en"))
		// .subject(MuskStatement2).add(RDF.SUBJECT, literal("Foundation Series", "en"))
		// .add(RDF.PREDICATE, "EX:among").add(RDF.OBJECT, literal("All-time best",
		// "en")).subject(MuskStatement3)
		// .add(RDF.SUBJECT, literal("Einstein: His Life and Universe",
		// "en")).add(RDF.PREDICATE, "EX:writtenBy")
		// .add(RDF.OBJECT, Isaacson).subject(Isaacson).add(FOAF.LAST_NAME,
		// literal("Isaacson", "en"));

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
		model.setNamespace(RDF.NS);
		model.setNamespace(RDFS.NS);
		model.setNamespace(FOAF.NS);
		model.setNamespace(EX);
		Model convertedModel = Models.convertReificationToRDFStar(model);
		// System.out.println(convertedModel);
		// Rio.write(convertedModel, System.out);
		Rio.write(convertedModel, System.out, RDFFormat.TURTLESTAR);

		/***** Part B *****/
//		FileOutputStream ttlsFormat = new FileOutputStream("./src/main/java/org/example/reifiedTriples.ttls");
		FileOutputStream ttlsFormat = new FileOutputStream("./target/classes/org/example/reifiedTriples.ttls");
		try {
			Rio.write(convertedModel, ttlsFormat, RDFFormat.TURTLESTAR);
		} finally {
			ttlsFormat.close();
		}

		// IRI john = Values.iri(ex, "john");
		// try (RepositoryConnection conn = rep.getConnection()) {
		// ElonMusk.add("EX:interview", MuskInterviewBNode);
		// conn.add(ElonMusk, "EX:interview", MuskInterviewBNode);
		//// conn.add(john, RDF.TYPE, FOAF.PERSON);
		//// conn.add(john, RDFS.LABEL, Values.literal("John"));
		// RepositoryResult<Statement> statements = conn.getStatements(null, null,
		// null);
		// Model model = QueryResults.asModel(statements);
		// model.setNamespace(RDF.NS);
		// model.setNamespace(RDFS.NS);
		// model.setNamespace(FOAF.NS);
		// model.setNamespace(EX);
		// Rio.write(model, System.out, RDFFormat.TURTLE);
		// }
		 String fileName = "reifiedTriples.ttls";
		 InputStream input = HelloRDF4J.class.getResourceAsStream("./" + fileName);
//		 System.out.println(input);
		 Model loadedModel = Rio.parse(input, "", RDFFormat.TURTLESTAR);
		 convertedModel = Models.convertRDFStarToReification(loadedModel);
		 System.out.println("\n\n\n\nRDF Star Model converted to Reification");
		 Rio.write(convertedModel, System.out, RDFFormat.TURTLE);
		 convertedModel = Models.convertReificationToRDFStar(convertedModel);
		 System.out.println("\n\n\n\nRDF Star Model converted to Reification");
		 Rio.write(convertedModel, System.out, RDFFormat.TURTLESTAR);
		// Model convertedModel = Models.convertReificationToRDFStar(model);
		// Model convertedModel = Models.convertRDFStarToReification(model);
		// Rio.write(convertedModel, System.out, RDFFormat.TURTLESTAR);
		// model.forEach(System.out::println);
//		 System.out.println("Working Directory = " + System.getProperty("user.dir"));
	}

}
