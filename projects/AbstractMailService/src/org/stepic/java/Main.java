package org.stepic.java;


import java.util.logging.*;

public class Main {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";


    public static void main(String[] args) {
            Main launch = new Main();
    }

    public Main() {

    }

    public static class UntrustworthyMailWorker implements MailService {

        private MailService [] services;
        RealMailService realMailService;

        public UntrustworthyMailWorker(MailService [] services) {
            int n = services.length;
            this.services = new MailService[n];
            for (int i = 0; i < n; ++i) {
                this.services[i] = services[i];
            }

            realMailService = new RealMailService();
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService service: services) {
                mail = service.processMail(mail);
            }
            return realMailService.processMail(mail);
        }

        public RealMailService getRealMailService() {
            return realMailService;
        }
    }

    public static class Spy  implements MailService {
        private final Logger spyLogger;
        public Spy(Logger LOGGER) {
            spyLogger = LOGGER;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                ((MailMessage) mail).getMessage();
                if (mail.getFrom().equals(AUSTIN_POWERS) || mail.getTo().equals(AUSTIN_POWERS)) {
                    spyLogger.log(Level.WARNING,
                            "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
                } else {
                    spyLogger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService{
        private final int minPrice;

        private static int stolenValue = 0;

        public Thief (int minPrice) {
            this.minPrice = minPrice;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                int currentPackagePrice = ((MailPackage) mail).getContent().getPrice();
                String currentPackageContent = ((MailPackage) mail).getContent().getContent();
                if (currentPackagePrice >= minPrice) {
                    stolenValue += currentPackagePrice;

                    Sendable stolenMail = new MailPackage(mail.getFrom(), mail.getTo(),
                            new Package("stones instead of " + currentPackageContent, 0));

                    return stolenMail;
                }

                return mail;
            }

            return mail;
        }

        public int getStolenValue() {
            return stolenValue;
        }
    }


    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                String currentPackageContent = ((MailPackage) mail).getContent().getContent();

                if (currentPackageContent.contains(WEAPONS) || currentPackageContent.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                if (currentPackageContent.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {}
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {}
    }
}
