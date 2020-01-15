import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Spy spy = new Spy(Logger.getLogger("1"));

        spy.processMail(new MailMessage("Austin Powers", "2", "3"));
    }

    public static class UntrustworthyMailWorker implements MailService {

        private MailService[] services;

        private RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] mailServices) {
            services = mailServices;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable cur = mail;
            for (int i = 0; i < services.length; ++i)
                cur = services[i].processMail(cur);
            return realMailService.processMail(cur);
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }
    }

    public static class Spy implements MailService {

        public static final String AUSTIN_POWERS = "Austin Powers";

        private static Logger LOGGER;

        public Spy(Logger logger) {
            LOGGER = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (mail.getFrom().contains(AUSTIN_POWERS) | mail.getTo().contains(AUSTIN_POWERS)) {
                    LOGGER.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
                } else {
                    LOGGER.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService {

        private int StolenValue;
        private int MinPrice;

        public Thief(int a) {
            MinPrice = a;
            StolenValue = 0;
        }

        public int getStolenValue() {
            return StolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getPrice() >= MinPrice) {
                    StolenValue += ((MailPackage) mail).getContent().getPrice();
                    return new MailPackage(mail.getFrom(), mail.getTo(),
                            new Package("stones instead of " + ((MailPackage) mail).getContent().getContent(), 0));
                }
            }
            return mail;
        }
    }

    public static class Inspector implements MailService {

        public static final String WEAPONS = "weapons";
        public static final String BANNED_SUBSTANCE = "banned substance";

        public static final String STONES = "stones";

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getContent().contains(WEAPONS)
                        | ((MailPackage) mail).getContent().getContent().contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException("");
                }
                if (((MailPackage) mail).getContent().getContent().contains(STONES)) {
                    throw new StolenPackageException("");
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {

        public IllegalPackageException(String message) {
            super(message);
        }

        public IllegalPackageException(String message, Throwable cause) {
            super(message, cause);
        }

        public IllegalPackageException() {
            super();
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException(String message) {
            super(message);
        }

        public StolenPackageException(String message, Throwable cause) {
            super(message, cause);
        }

        public StolenPackageException() {
            super();
        }
    }

    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    public static interface Sendable {
        String getFrom();

        String getTo();
    }

    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }

    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }

    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }

    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }
}

