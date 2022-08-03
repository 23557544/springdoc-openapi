/*
 *
 *  * Copyright 2019-2020 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package test.org.springdoc.api.app31;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;

@RestController
public class HelloController {

	@GetMapping(value = "/search", produces = { "application/xml", "application/json" })
	public ResponseEntity<List<PersonDTO>> getAllPets(@SortDefault("name") @ParameterObject Sort sort) {
		return null;
	}


	@GetMapping("/test1")
	public String getPatientList1(@SortDefault(sort = { "someField", "someoTHER" },
			direction = Direction.DESC)
	@ParameterObject Sort sort) {
		return "bla";
	}

	@GetMapping("/test2")
	public String getPatientList2(@SortDefault(sort = "someField",
			direction = Direction.DESC)
	@ParameterObject Sort sort) {
		return "bla";
	}

	@GetMapping("/test3")
	public String getPatientList3(@SortDefault(sort = { "someField", "someoTHER" },
			direction = Direction.DESC)
	@ParameterObject Pageable pageable) {
		return "bla";
	}

	@GetMapping("/test4")
	public String getPatientList4(@SortDefault(sort = "someField",
			direction = Direction.DESC)
	@ParameterObject Pageable pageable) {
		return "bla";
	}
}
