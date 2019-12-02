package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

public class JobTest {

    private Job jobOne;
    private Job jobTwo;

    @Before
    public void before() {
        jobOne = new Job();
        jobTwo = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertTrue(!jobOne.equals(jobTwo));
        assertTrue(jobTwo.getId() - jobOne.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobThree.getName() != null && jobThree.getName() == "Product tester");
        assertEquals(jobThree.getEmployer().getValue(), "ACME");
        assertEquals(jobThree.getLocation().getValue(), "Desert");
        assertEquals(jobThree.getPositionType().getValue(), "Quality control");
        assertEquals(jobThree.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job jobFour = new Job("Sample tester", new Employer("Sample Employer"), new Location("Sample Location"), new PositionType("Sample Position"), new CoreCompetency("Sample"));
        Job jobFive = new Job("Sample tester", new Employer("Sample Employer"), new Location("Sample Location"), new PositionType("Sample Position"), new CoreCompetency("Sample"));
         assertFalse(jobFour.equals(jobFive));
    }

    @Test
    public void testForBlankLineBeforeAndAfterLine() {
        Job jobSix = new Job("NameFld", new Employer(  "EmployerFld"), new Location("LocationFld"), new PositionType("PosTypeFld"), new CoreCompetency("CoreCompFld " ));
        assertTrue(jobSix.toString().startsWith(""));
        assertTrue(jobSix.toString().endsWith(""));
    }

    @Test
    public void testForLabelAndFieldValues() {
        Job jobSeven = new Job("NameFld", new Employer("EmployerFld"), new Location("LocationFld"), new PositionType("PosTypeFld"), new CoreCompetency("CoreCompFld"));
        String[] labelFld = jobSeven.toString().split("\n");
        assertEquals( "Name: NameFld", labelFld[2]);
        assertEquals("Employer EmployerFld", labelFld[3]);
        assertEquals("Location: LocationFld", labelFld[4]);
        assertEquals("Position Type: PosTypeFld", labelFld[5]);
        assertEquals("Core Competency: CoreCompFld", labelFld[6]);
    }

    @Test
    public void testForEmptyField() {
        Job jobEight = new Job( " ", new Employer("EmployerFld"), new Location("LocationFld"), new PositionType("PosTypeFld"), new CoreCompetency("CoreCompFld"));
        String[] emptyField = jobEight.toString().split("\n");
        assertEquals("Name: Data not available", emptyField[2]);

    }


}
