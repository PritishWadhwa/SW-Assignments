/**
 * 
 */
package org.example;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.util.Models;
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
//		Repository rep = new SailRepository(new MemoryStore());
//		Namespace ex = Values.namespace("ex", "http://example.org/");
//		IRI john = Values.iri(ex, "john");
//		try (RepositoryConnection conn = rep.getConnection()) {
			// conn.add(john, RDF.TYPE, FOAF.PERSON);
			// conn.add(john, RDFS.LABEL, Values.literal("John"));
			// RepositoryResult<Statement> statements = conn.getStatements(null, null,
			// null);
			// Model model = QueryResults.asModel(statements);
			// model.setNamespace(RDF.NS);
			// model.setNamespace(RDFS.NS);
			// model.setNamespace(FOAF.NS);
			// model.setNamespace(ex);
			// Rio.write(model, System.out, RDFFormat.TURTLE);
			
//		}
		String fileName = "test.ttl";
		InputStream input = HelloRDF4J.class.getResourceAsStream("./" + fileName);
//		System.out.println(input);
		Model model = Rio.parse(input, "", RDFFormat.TRIG);
		Model convertedModel = Models.convertReificationToRDFStar(model); 
		Rio.write(convertedModel, System.out, RDFFormat.TURTLESTAR);
//		model.forEach(System.out::println);
//		System.out.println("Working Directory = " + System.getProperty("user.dir"));
	}

}
