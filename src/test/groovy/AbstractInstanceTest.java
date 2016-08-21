import java.net.URI;

import org.junit.Test;

import eu.esdihumboldt.hale.common.instance.model.InstanceCollection;

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

/**
 * Base class that provides tests based on data sets loaded as instance collections.
 *
 * @author Simon Templer
 */
public abstract class AbstractInstanceTest extends AbstractTest {

  public static final URI TN_RO_SCHEMA = URI.create(
      "http://inspire.ec.europa.eu/schemas/tn-ro/4.0/RoadTransportNetwork.xsd");
  public static final URI TN_RO_DATA_SMALL = URI.create(
      AbstractInstanceTest.class.getResource("tn-ro_hh_basis-dlm_teil.gml.gz").toString());
  public static final URI TN_RO_DATA_BIG = URI.create(
      AbstractInstanceTest.class.getResource("tn-ro_hh_basis-dlm_komplett.gml.gz").toString());

  protected abstract void handleInstances(InstanceCollection instances, URI schema);

  public void defaultInstanceTest(URI schema, URI data) throws Exception {
    InstanceCollection instances = loadInstances(schema, data);
    handleInstances(instances, schema);
  }

  @Test
  public void testRoadTransportSmall() throws Exception {
    defaultInstanceTest(TN_RO_SCHEMA, TN_RO_DATA_SMALL);
  }

  @Test
  public void testRoadTransportBig() throws Exception {
    defaultInstanceTest(TN_RO_SCHEMA, TN_RO_DATA_BIG);
  }

}
