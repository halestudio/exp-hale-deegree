/*
 * Copyright 2016 by it's authors.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution. If not, see <http://www.gnu.org/licenses/>.
 */

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.eclipse.equinox.nonosgi.registry.RegistryFactoryHelper;
import org.junit.BeforeClass;

import eu.esdihumboldt.hale.common.core.io.HaleIO;
import eu.esdihumboldt.hale.common.core.io.report.IOReport;
import eu.esdihumboldt.hale.common.core.io.supplier.DefaultInputSupplier;
import eu.esdihumboldt.hale.common.instance.io.InstanceReader;
import eu.esdihumboldt.hale.common.instance.model.InstanceCollection;
import eu.esdihumboldt.hale.common.schema.io.SchemaReader;
import eu.esdihumboldt.hale.io.xsd.reader.XmlSchemaReader;


/**
 * Abstract test class performing necessary initialization and providing common
 * tasks.
 *
 * @author Simon Templer
 */
public class AbstractTest {

  @BeforeClass
  public static void initHale() {
    // initialize registry
    RegistryFactoryHelper.getRegistry();
  }

  public InstanceCollection loadInstances(URI schema, URI data) throws Exception {
    // load schema
    SchemaReader schemaReader = new XmlSchemaReader();
    schemaReader.setSource(new DefaultInputSupplier(schema));
    IOReport schemaReport = schemaReader.execute(null);
    assertTrue("Loading the schema failed", schemaReport.isSuccess());
    assertTrue("Errors while loading the schema", schemaReport.getErrors().isEmpty());

    // load instances
    DefaultInputSupplier in = new DefaultInputSupplier(data);
    InstanceReader instanceReader = HaleIO.findIOProvider(InstanceReader.class, in, data.toString());
    assertNotNull("Instance reader could not be determined", instanceReader);
    instanceReader.setSourceSchema(schemaReader.getSchema());
    instanceReader.setSource(in);
    IOReport instanceReport = instanceReader.execute(null);
    assertTrue("Loading the instances failed", instanceReport.isSuccess());
    assertTrue("Errors while loading the instances", instanceReport.getErrors().isEmpty());

    return instanceReader.getInstances();
  }

}
