package dgsw.pioneers.checkIn.domain.question.application.port.in;

import dgsw.pioneers.checkIn.domain.question.application.domain.model.Question;

import java.util.List;

public interface QuestionLoadUseCase {

    List<Question> loadAllQuestion();
}
