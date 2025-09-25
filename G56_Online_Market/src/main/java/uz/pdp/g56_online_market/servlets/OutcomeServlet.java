package uz.pdp.g56_online_market.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.g56_online_market.daos.ProductDAO;
import uz.pdp.g56_online_market.entities.Outcome;
import uz.pdp.g56_online_market.entities.Products;
import uz.pdp.g56_online_market.services.OutcomeService;

import java.io.IOException;
import java.util.List;

@WebServlet("/outcomes")
public class OutcomeServlet extends HttpServlet {
    private final OutcomeService outcomeService = new OutcomeService();
    private final ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Barcha chiqimlarni olish
        List<Outcome> outcomes = outcomeService.getAllOutcomes();

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h2>📋 Outcome List</h2>");

        // Jadval ko‘rinishida chiqarish
        resp.getWriter().println("<table border='1' cellspacing='0' cellpadding='5'>");
        resp.getWriter().println("<tr>");
        resp.getWriter().println("<th>ID</th>");
        resp.getWriter().println("<th>Sana</th>");
        resp.getWriter().println("<th>Product</th>");
        resp.getWriter().println("<th>Amount</th>");
        resp.getWriter().println("<th>Actions</th>");
        resp.getWriter().println("</tr>");

        for (Outcome outcome : outcomes) {
            resp.getWriter().println("<tr>");
            resp.getWriter().println("<td>" + outcome.getId() + "</td>");
            resp.getWriter().println("<td>" + (outcome.getProduct() != null ? outcome.getProduct().getName() : "-") + "</td>");
            resp.getWriter().println("<td>" + outcome.getAmount() + "</td>");
            resp.getWriter().println("<td><a href='/outcomes/delete?id=" + outcome.getId() + "'>❌ Delete</a></td>");
            resp.getWriter().println("</tr>");
        }
        resp.getWriter().println("</table>");

        // Forma orqali yangi chiqim qo‘shish
        resp.getWriter().println("<h3>➕ Yangi Outcome qo‘shish</h3>");
        resp.getWriter().println("<form method='post' action='/outcomes'>");
        resp.getWriter().println("Product ID: <input type='number' name='productId'><br>");
        resp.getWriter().println("Quantity: <input type='number' name='quantity'><br>");
        resp.getWriter().println("Amount: <input type='number' step='0.01' name='amount'><br>");
        resp.getWriter().println("Description: <input type='text' name='description'><br>");
        resp.getWriter().println("<button type='submit'>Qo‘shish</button>");
        resp.getWriter().println("</form>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long productId = Long.parseLong(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double amount = Double.parseDouble(req.getParameter("amount"));
        String description = req.getParameter("description");

        // ⚡ Bazadan product topamiz
        Products product =
                new ProductDAO().findById(productId);

        Outcome outcome = Outcome.builder()
                .product(product) // ⚡ majburiy field
                .quantity(quantity)
                .amount(amount)
                .description(description)
                .build();

        outcomeService.addOutcome(outcome);

        resp.sendRedirect("/outcomes");
    }

}

