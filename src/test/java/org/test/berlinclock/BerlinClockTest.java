package org.test.berlinclock;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class BerlinClockTest {
	BerlinClock berlinClock = new BerlinClock();

	@Test
	public void testBerlinClockResult() {
		String berlinTime = berlinClock.changeInputTimeToBerlinTime("16:37:16");
		String expected = Arrays.toString(new String[] { "Y", "RRRO", "ROOO", "YYRYYRYOOOO", "YYOO" });
		Assert.assertEquals(expected, berlinTime);

	}

	@Test
	public void testYellowLampShouldBlinkOnOffInEveryTwoSeconds() {
		Assert.assertEquals("Y", berlinClock.calculateSeconds(0));
		Assert.assertEquals("O", berlinClock.calculateSeconds(1));
		Assert.assertEquals("O", berlinClock.calculateSeconds(59));
	}

	@Test
	public void testUpperRowHoursShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClock.calculateUpperRowHours(7).length());
	}

	@Test
	public void testUpperRowHoursShouldLightRedLampForEvery5Hours() {
		Assert.assertEquals("RRRR", berlinClock.calculateUpperRowHours(23));
		Assert.assertEquals("RRRR", berlinClock.calculateUpperRowHours(24));
		Assert.assertEquals("OOOO", berlinClock.calculateUpperRowHours(0));
		Assert.assertEquals("RROO", berlinClock.calculateUpperRowHours(13));

	}

	@Test
	public void testLowerRowHoursShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClock.calculateLowerRowHours(5).length());
	}

	@Test
	public void testBottomHoursShouldLightRedLampForEveryHourLeftFromTopHours() {
		Assert.assertEquals("RRRO", berlinClock.calculateLowerRowHours(13));
		Assert.assertEquals("RRRO", berlinClock.calculateLowerRowHours(23));
		Assert.assertEquals("OOOO", berlinClock.calculateLowerRowHours(0));
		Assert.assertEquals("RRRR", berlinClock.calculateLowerRowHours(24));
	}

	@Test
	public void testUpperRowMinutesShouldHave11Lamps() {
		Assert.assertEquals(11, berlinClock.calculateUpperRowMinutes(34).length());
	}

	@Test
	public void testUpperRowMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarter() {
		String minutes32 = berlinClock.calculateUpperRowMinutes(32);
		Assert.assertEquals("R", minutes32.substring(2, 3));
		Assert.assertEquals("R", minutes32.substring(5, 6));
		Assert.assertEquals("O", minutes32.substring(8, 9));
	}

	@Test
	public void testUpperRowMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
		Assert.assertEquals("OOOOOOOOOOO", berlinClock.calculateUpperRowMinutes(0));
		Assert.assertEquals("YYROOOOOOOO", berlinClock.calculateUpperRowMinutes(17));
		Assert.assertEquals("YYRYYRYYRYY", berlinClock.calculateUpperRowMinutes(59));
	}

	@Test
	public void testLowerRowMinutesShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClock.calculateLowerRowMinutes(0).length());
	}

	@Test
	public void testLoweRowMinutesShouldLightYellowLampForEveryMinuteLeftFromTopMinutes() {
		Assert.assertEquals("OOOO", berlinClock.calculateLowerRowMinutes(0));
		Assert.assertEquals("YYOO", berlinClock.calculateLowerRowMinutes(17));
		Assert.assertEquals("YYYY", berlinClock.calculateLowerRowMinutes(59));
	}

}
