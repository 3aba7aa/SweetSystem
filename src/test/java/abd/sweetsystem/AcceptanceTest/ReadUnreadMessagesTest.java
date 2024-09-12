package abd.sweetsystem.AcceptanceTest;

import abd.sweetsystem.clasess.Message;
import abd.sweetsystem.clasess.OwnerAndSupplier;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Tag;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Tag("tag2")
public class ReadUnreadMessagesTest {

    private OwnerAndSupplier receiver;

    @Given("a receiver with ID {int} exists")
    public void a_receiver_with_id_exists(int receiverId) {
        receiver = OwnerAndSupplier.getOwnerSupplier(receiverId);
        receiver.getReadMessages().clear();
    }

    @Given("the receiver has {int} unread messages")
    public void the_receiver_has_unread_messages(int count) {
        for (int i = 1; i <= count; i++) {
            Message message = new Message(i, receiver.getUserName(), "Message " + i);
            receiver.receiveMessage(message);
        }
    }

    @Given("the messages are {string}")
    public void the_messages_are(String message3) {
        receiver.getUnreadMessages().clear();
        receiver.getUnreadMessages().add(new Message(3, receiver.getUserName(), message3));
    }

    @When("the receiver reads all unread messages")
    public void the_receiver_reads_all_unread_messages() {
        receiver.readUnreadMessages();
    }

    @Then("all unread messages should be moved to the read messages list")
    public void all_unread_messages_should_be_moved_to_the_read_messages_list() {
        assertEquals(1, receiver.getReadMessages().size());
    }

    @Then("the read messages list should contain {string}")
    public void the_read_messages_list_should_contain(String message3) {
        List<String> readMessageContents = new ArrayList<>();
        for (Message message : receiver.getReadMessages()) {
            readMessageContents.add(message.getContent());
        }
        assertEquals(List.of(message3), readMessageContents);
    }

    @Then("the unread messages list should be empty")
    public void the_unread_messages_list_should_be_empty() {
        assertEquals(0, receiver.getUnreadMessages().size());
    }

    @Given("the receiver has no unread messages")
    public void the_receiver_has_no_unread_messages() {
        receiver.getUnreadMessages().clear();
    }

    @Then("the read messages list should remain empty")
    public void the_read_messages_list_should_remain_empty() {
        assertEquals(0, receiver.getReadMessages().size());
    }

    @Then("the unread messages list should remain empty")
    public void the_unread_messages_list_should_remain_empty() {
        assertEquals(0, receiver.getUnreadMessages().size());
    }
}
