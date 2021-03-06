package org.secuso.privacyfriendlysolitaire.test;
/*
This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.junit.Before;
import org.junit.Test;
import org.secuso.privacyfriendlysolitaire.model.Card;
import org.secuso.privacyfriendlysolitaire.model.DeckWaste;
import org.secuso.privacyfriendlysolitaire.model.Rank;
import org.secuso.privacyfriendlysolitaire.model.Suit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

/**
 * @author M. Fischer
 */

public class DeckWasteTests {
    private DeckWaste deckwaste1;
    private DeckWaste deckwaste3;
    private Vector<Card> clubs;

    @Before
    public void init() {
        clubs = new Vector<Card>();
        for (Rank r : Rank.values()) {
            clubs.add(new Card(r, Suit.CLUBS));
        }
        deckwaste1 = new DeckWaste(1);
        deckwaste1.setDeck(clubs);
        deckwaste3 = new DeckWaste(3);
        deckwaste3.setDeck(clubs);
    }

    @Test
    public void turnOverAndResetTests() {
        assertFalse("deckwaste1 should not be resetable now", deckwaste1.canReset());
        assertFalse("deckwaste1 should not be resetable now", deckwaste1.reset());
        assertTrue("deckwaste1 should allow turn over now", deckwaste1.canTurnOver());
        for (int i = 0; i < 13; ++i) {
            assertTrue("turning over on deckwaste1 should be possible 13 times", deckwaste1.turnOver());
        }
        assertFalse("deck of deckwaste1 should now be empty", deckwaste1.canTurnOver());
        assertFalse("deck of deckwaste1 should now be empty", deckwaste1.turnOver());
        for (int j = 0; j < clubs.size(); ++j) {
            assertTrue("waste of deckwaste1 should be clubs in reverse order", clubs.get(j).getRank() == deckwaste1.getWaste().get(deckwaste1.getWaste().size() - 1 - j).getRank());
        }
        assertTrue("deckwaste1 should be resetable now", deckwaste1.canReset());
        assertTrue("deckwaste1 should be resetable now", deckwaste1.reset());
        for (int k = 0; k < clubs.size(); ++k) {
            assertTrue("deck of deckwaste1 should be clubs again", clubs.get(k).getRank() == deckwaste1.getDeck().get(k).getRank());
        }

        assertFalse("deckwaste3 should not be resetable now", deckwaste3.canReset());
        assertFalse("deckwaste3 should not be resetable now", deckwaste3.reset());
        assertTrue("deckwaste3 should allow turn over now", deckwaste3.canTurnOver());
        for (int i = 0; i < 5; ++i) {
            assertTrue("turning over on deckwaste1 should be possible 5 times", deckwaste3.turnOver());
        }
        assertFalse("deck of deckwaste3 should now be empty", deckwaste3.canTurnOver());
        assertFalse("deck of deckwaste3 should now be empty", deckwaste3.turnOver());
        for (int j = 0; j < clubs.size(); ++j) {
            assertTrue("waste of deckwaste3 should be clubs in reverse order", clubs.get(j).getRank() == deckwaste3.getWaste().get(deckwaste3.getWaste().size() - 1 - j).getRank());
        }
        assertTrue("deckwaste3 should be resetable now", deckwaste3.canReset());
        assertTrue("deckwaste3 should be resetable now", deckwaste3.reset());
        for (int k = 0; k < clubs.size(); ++k) {
            assertTrue("deck of deckwaste3 should be clubs again", clubs.get(k).getRank() == deckwaste3.getDeck().get(k).getRank());
        }
    }

    @Test
    public void wasteTopTests() {
        deckwaste1.setWaste(clubs);
        assertTrue("Rank of top card of waste should be KING", deckwaste1.getWasteTop().getRank() == Rank.KING);
        assertTrue("Rank of top card of waste should be KING", deckwaste1.removeWasteTop().getRank() == Rank.KING);
        assertTrue("Rank of top card of waste should now be QUEEN", deckwaste1.getWasteTop().getRank() == Rank.QUEEN);
        assertTrue("Rank of top card of waste should now be QUEEN", deckwaste1.removeWasteTop().getRank() == Rank.QUEEN);
        assertTrue("Rank of top card of waste should now be JACK", deckwaste1.getWasteTop().getRank() == Rank.JACK);
        assertTrue("Rank of top card of waste should now be JACK", deckwaste1.removeWasteTop().getRank() == Rank.JACK);
        assertTrue("Rank of top card of waste should now be TEN", deckwaste1.getWasteTop().getRank() == Rank.TEN);
        assertTrue("Rank of top card of waste should now be TEN", deckwaste1.removeWasteTop().getRank() == Rank.TEN);
        assertTrue("Rank of top card of waste should now be NINE", deckwaste1.getWasteTop().getRank() == Rank.NINE);
        assertTrue("Rank of top card of waste should now be NINE", deckwaste1.removeWasteTop().getRank() == Rank.NINE);
        assertTrue("Rank of top card of waste should now be EIGHT", deckwaste1.getWasteTop().getRank() == Rank.EIGHT);
        assertTrue("Rank of top card of waste should now be EIGHT", deckwaste1.removeWasteTop().getRank() == Rank.EIGHT);
    }
}
