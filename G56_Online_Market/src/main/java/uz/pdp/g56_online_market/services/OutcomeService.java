package uz.pdp.g56_online_market.services;

import uz.pdp.g56_online_market.daos.OutcomeDAO;
import uz.pdp.g56_online_market.entities.Outcome;

import java.util.List;

public class OutcomeService {

//    private final OutcomeDAO outcomeDAO = new OutcomeDAO();
//
//    // Faqat Admin ko‘ra oladi
//    public List<Outcome> getAllOutcomes(User currentUser) {
//        if (currentUser != null && "ADMIN".equals(currentUser.getRole())) {
//            return outcomeDAO.findAll();
//        }
//        throw new SecurityException("Sizda Outcome’larni ko‘rish huquqi yo‘q!");
//    }
//
//    public void addOutcome(User currentUser, Outcome outcome) {
//        if (currentUser != null && "ADMIN".equals(currentUser.getRole())) {
//            outcomeDAO.save(outcome);
//        } else {
//            throw new SecurityException("Faqat ADMIN Outcome qo‘shishi mumkin!");
//        }
//    }

    private final OutcomeDAO outcomeDAO = new OutcomeDAO();

    // Yangi chiqim qo‘shish
    public void addOutcome(Outcome outcome) {
        outcomeDAO.save(outcome);
        System.out.println("✅ Outcome qo‘shildi: " + outcome);
    }

    // Chiqimni yangilash
    public void updateOutcome(Outcome outcome) {
        outcomeDAO.update(outcome);
        System.out.println("♻️ Outcome yangilandi: " + outcome);
    }

    // Chiqimni o‘chirish
    public void deleteOutcome(Long id) {
        outcomeDAO.delete(id);
        System.out.println("❌ Outcome o‘chirildi: id = " + id);
    }

    // ID bo‘yicha chiqimni olish
    public Outcome getOutcomeById(Long id) {
        return outcomeDAO.findById(id);
    }

    public List<Outcome> getAllOutcomes() {
        return outcomeDAO.findAll();
    }
}

