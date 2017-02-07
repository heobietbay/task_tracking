package khoa.training.task.tracking.exception;

import io.katharsis.errorhandling.ErrorData;
import io.katharsis.errorhandling.ErrorResponse;
import io.katharsis.errorhandling.mapper.ExceptionMapperProvider;
import io.katharsis.errorhandling.mapper.JsonApiExceptionMapper;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.katharsis.response.HttpStatus.CONFLICT_409;

/**
 * Created by trandangkhoa on 2/7/2017.
 */
@ExceptionMapperProvider
public class ConstraintViolationExceptionMapper  implements JsonApiExceptionMapper<ConstraintViolationException> {

    @Override
    public ErrorResponse toErrorResponse(ConstraintViolationException cve) {
        List<ErrorData> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : cve.getConstraintViolations()) {
            ErrorData error = ErrorData.builder()
                    .setStatus(String.valueOf(CONFLICT_409))
                    .setTitle(violation.getMessage())
                    .setSourcePointer(createSourcePointer(violation))
                    .build();

            errors.add(error);
        }

        return ErrorResponse.builder().setStatus(CONFLICT_409).setErrorData(errors).build();
    }

    private String createSourcePointer(ConstraintViolation<?> violation) {
        String attributeName = findAttributeName(violation);
        String sourcePointer = "/data/attributes/" + attributeName;
        return sourcePointer;
    }

    private String findAttributeName(ConstraintViolation<?> violation) {
        for (Iterator<Path.Node> iterator = violation.getPropertyPath().iterator(); iterator.hasNext();) {
            Path.Node node = iterator.next();
            if (!iterator.hasNext()) {
                return node.getName();
            }
        }
        return null;
    }

}